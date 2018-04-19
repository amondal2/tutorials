import styled from 'styled-components';
import React from 'react';

const TeamWrapper = styled.div`
  grid-column: 1;
  grid-row: 1 / 4;
  background-color: #362234;
  color: #958993;
`;

const team = ({ id, letter }) => <li key={`team-${id}`}>{letter}</li>;

export default ({ teams }) => (
  <TeamWrapper>
    <div>
      <ul>
        {teams.map(team)}
      </ul>
    </div>
  </TeamWrapper>
);
