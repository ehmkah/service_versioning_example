package de.ehmkah.projects.service_example.soap_service.domain;

import com.google.common.collect.HashMultimap;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Michael Krausse (ehmkah)
 */
@Service
public class NeigbhbourCheckService {

  private final HashMultimap<String, String> goodNeighbours;
  private final HashMultimap<String, String> badNeighbours;

  public NeigbhbourCheckService() {
    goodNeighbours = createGoodNeighbours();
    badNeighbours = createBadNeighbours();
  }

  private HashMultimap<String, String> createBadNeighbours() {
    HashMultimap result = HashMultimap.create();
    result.put("TOMATO", "PEA");
    result.put("TOMATO", "POTATO");

    return result;
  }

  private HashMultimap<String, String> createGoodNeighbours() {
    HashMultimap<String, String> result = HashMultimap.create();
    result.put("TOMATO", "GARLIC");
    result.put("TOMATO", "SPINACH");

    return result;
  }

  public String areGood(String speciesOne, String speciesTwo) {
    if (check(speciesOne, speciesTwo, goodNeighbours)) return "YES";
    if (check(speciesOne, speciesTwo, badNeighbours)) return "NO";
    return "UNKNOWN";
  }

  private boolean check(String speciesOne, String speciesTwo, HashMultimap<String, String> neighbours) {
    Set<String> goodNeighboursSet = neighbours.get(speciesOne);
    if (goodNeighboursSet.contains(speciesTwo)) {
      return true;
    }
    goodNeighboursSet = neighbours.get(speciesTwo);
    if (goodNeighboursSet.contains(speciesOne)) {
      return true;
    }
    return false;
  }
}
