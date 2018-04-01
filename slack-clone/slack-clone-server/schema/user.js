export default `

    type User {
        id: Int!
        email: String!
        username: String!
        teams: [Team!]!
    }

    type Mutation {
        createUser(username: String!, email: String!, password: String!): User!
    }

    type Query {
        getUser(id: Int!): User!
        allUsers: [User!]!
    }
`;
