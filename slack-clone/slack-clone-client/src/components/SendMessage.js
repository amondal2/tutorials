import styled from 'styled-components';
import React from 'react';
import { Input } from 'semantic-ui-react';

const SendMessageWrapper = styled.div`
  grid-column: 3;
  grid-row: 3;
  margin: 20;
`;

export default ({ channelName }) => (
  <SendMessageWrapper>
    <Input fluid placeholder={`Message # ${channelName}`} />
  </SendMessageWrapper>
);
