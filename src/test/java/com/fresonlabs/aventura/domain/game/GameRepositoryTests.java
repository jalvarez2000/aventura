package com.fresonlabs.aventura.domain.game;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import com.fresonlabs.aventura.AventuraApplication;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GameRepositoryTests {

  @Autowired
  GameRepository gameRepository;

  @Autowired
  GameService gameService;

  GameRepositoryTests() throws IOException {
    System.out.println("Setting up");
    ClassLoader classLoader = AventuraApplication.class.getClassLoader();
    File file = new File(Objects.requireNonNull(classLoader.getResource("serviceAccount.json")).getFile());

    FileInputStream serviceAccount =
        new FileInputStream(file.getAbsolutePath());

    FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .build();

    FirebaseApp.initializeApp(options);
  }

  @Test
  void getExistingGameTest() {
    final String gameId = "6VgFHH0eftew5fVtqPQx";
    Optional<GameModel> game = gameRepository.findById(gameId);
    assertTrue(game.isPresent());
  }

  @Test
  void getNonExistingGameTest() {
    final String gameId = "nonexisting";
    Optional<GameModel> game = gameRepository.findById(gameId);
    assertFalse(game.isPresent());
  }
}
