package com.fresonlabs.aventura.domain.game;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

import com.fresonlabs.aventura.AventuraApplication;
import com.fresonlabs.aventura.domain.player.PlayerModel;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameServiceTests {

  @Autowired
  GameService gameService;

  GameServiceTests() throws IOException {
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
  public void test() {
    Optional<PlayerModel> player = gameService.getPlayer("6VgFHH0eftew5fVtqPQx", "vMuh9DemJcOSTInDF9V2IFWQVyy2");
    assertTrue(player.isPresent());
  }

}
