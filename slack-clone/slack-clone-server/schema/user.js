export default `

    type User {
        id: Int!
        email: String!
        username: String!
        teams: [Team!]!
    }

    type Mutation {
        register(username: String!, email: String!, password: String!): RegisterResponse!
    }

    type RegisterResponse {
        ok: Boolean!
        user: User
        errors: [Error!]
    }

    type Query {
        getUser(id: Int!): User!
        allUsers: [User!]!
    }
`;
