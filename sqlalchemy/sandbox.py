import config
import sqlalchemy
from sqlalchemy.orm import sessionmaker
from sqlalchemy.ext.automap import automap_base
from datetime import datetime
import random


def connect(user, password, db, host, port):
    # connect to existing slack db, return the connection
    # object and metadata
    url = 'postgresql://{}:{}@{}:{}/{}'
    url = url.format(user, password, host, port, db)

    con = sqlalchemy.create_engine(url, client_encoding='utf8')
    meta = sqlalchemy.MetaData(bind=con, reflect=True)
    return con, meta

if __name__ == '__main__':
    # ha ha u can't hack me
    user = config.USER
    password = config.PASSWORD
    db = config.DB
    host = config.HOST
    port = config.PORT
    connection, meta = connect(user, password, db, host, port)
    # let's look at the tables
    print("TABLES >>")
    for table in meta.tables:
        print(table)
    print('\n')
    # construct auto_map so we can look at the rows!
    Base = automap_base()
    Base.prepare(connection, reflect=True)
    Session = sessionmaker()
    Session.configure(bind=connection)
    session = Session()

    # let's go through and run some fetch queries first
    User = Base.classes.users
    all_users = session.query(User).all()
    print("USERS >>")
    for user in all_users:
        print(user.username, user.email)
    print('\n')
    Team = Base.classes.teams
    all_teams = session.query(Team).all()
    print("TEAMS >>")
    for team in all_teams:
        print(team.name)
    print('\n')

    # add a new team
    new_team_name = 'new team %i' % random.randint(0,1000)
    new_team = Team(name=new_team_name, created_at=datetime.now(), updated_at=datetime.now())
    session.add(new_team)
    session.commit()

    # get our new team back from the db
    new_team = session.query(Team).filter(Team.name==new_team_name).all()
    assert(len(new_team) == 1)
    assert(new_team[0].name == new_team_name)