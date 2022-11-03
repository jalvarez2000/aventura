package com.fresonlabs.aventura.domain.gamerequest;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Jacksonized @Builder
@Data
public class  GameRequestModel {
    String playerId;
    String gameId;
    GameCommandModel gameCommand;
}

