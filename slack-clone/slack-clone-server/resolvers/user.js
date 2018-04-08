import Hashes from 'jshashes';

export default {
  Query: {
    getUser: (parent, { id }, { models }) =>
      models.User.findOne({ where: { id } }),
    allUsers: (parent, args, { models }) => models.User.findAll(),
  },
  Mutation: {
    register: async (parent, { password, ...otherArgs }, { models }) => {
      try {
        const hashedPassword = new Hashes.SHA1().b64(password);
        await models.User.create({ ...otherArgs, password: hashedPassword });
        return true;
      } catch (err) {
        return false;
      }
    },
  },
};
