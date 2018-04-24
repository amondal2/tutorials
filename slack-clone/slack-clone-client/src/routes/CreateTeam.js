import React from 'react';
import { extendObservable } from 'mobx';
import { observer } from 'mobx-react';
import {
  Form,
  Button,
  Input,
  Container,
  Header,
  Message,
} from 'semantic-ui-react';
import { graphql } from 'react-apollo';
import gql from 'graphql-tag';

class CreateTeam extends React.Component {
  constructor(props) {
    super(props);

    extendObservable(this, {
      name: '',
      errors: {},
    });
  }

  onSubmit = async () => {
    const { name } = this;
    let response = null;

    try {
      response = await this.props.mutate({
        variables: { name },
      });
    } catch (err) {
      this.props.history.push('/login');
      return;
    }

    const { ok, errors, team } = response.data.createTeam;
    if (ok) {
      this.props.history.push(`/view-team/${team.id}`);
    } else {
      const err = {};
      errors.forEach(({ path, message }) => {
        err[`${path}Error`] = message;
      });
      this.errors = err;
    }
  };

  onChange = e => {
    const { name, value } = e.target;
    this[name] = value;
  };

  render() {
    const { name, errors: { nameError } } = this;
    const errorList = [];
    if (nameError) {
      errorList.push(nameError);
    }
    return (
      <Container text>
        <Header as="h2">Create Team</Header>
        <Form>
          <Form.Field error={!!nameError}>
            <Input
              name="name"
              onChange={this.onChange}
              value={name}
              placeholder="Name"
              fluid
            />
          </Form.Field>
          <Button onClick={this.onSubmit}>Submit</Button>
        </Form>
        {errorList.length ? (
          <Message error header="There was an error." list={errorList} />
        ) : null}
      </Container>
    );
  }
}

const createTeamMutation = gql`
  mutation($name: String!) {
    createTeam(name: $name) {
      ok
      team {
        id
      }
      errors {
        message
        path
      }
    }
  }
`;

export default graphql(createTeamMutation)(observer(CreateTeam));
