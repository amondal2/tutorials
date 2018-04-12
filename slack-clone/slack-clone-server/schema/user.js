export default `

    type User {
        id: Int!
        email: String!
        username: String!
        teams: [Team!]!
    }

    type LoginResponse {
        ok: Boolean!
        token: String
        errors: [Error!]
        refreshToken: String
    }

    type Mutation {
        register(username: String!, email: String!, password: String!): RegisterResponse!
        login(email: String!, password: String!): LoginResponse!
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
