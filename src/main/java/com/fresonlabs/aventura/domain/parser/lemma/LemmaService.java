package com.fresonlabs.aventura.domain.parser.lemma;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


@Service
public class LemmaService {
    List<LemmaModel> lemmas = new ArrayList<>();
    public LemmaService() throws ExecutionException, InterruptedException {
        Firestore dbFireStore = FirestoreClient.getFirestore();
        CollectionReference collectionReference = dbFireStore.collection("lemmas");
        ApiFuture<QuerySnapshot> futureSnapshot = collectionReference.get();
        QuerySnapshot snapshot = futureSnapshot.get();
        snapshot.getDocuments().forEach(item -> {
            LemmaModel lemma = item.toObject(LemmaModel.class);
            this.lemmas.add(lemma);
        });
    }

    public String findRootAction(String action) {
        LemmaModel optLemma = lemmas.stream().filter(item -> item.dictionary.contains(action)).findFirst().get();
        return optLemma.getRoot();
    }
}
