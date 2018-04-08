export default `

    type User {
        id: Int!
        email: String!
        username: String!
        teams: [Team!]!
    }

    type Mutation {
        register(username: String!, email: String!, password: String!): Boolean!
    }

    type Query {
        getUser(id: Int!): User!
        allUsers: [User!]!
    }
`;
