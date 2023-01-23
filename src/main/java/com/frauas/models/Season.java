package com.frauas.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Season {
    private static List<Map<LocalDate, List<Match>>> seasonList = new ArrayList<>();

    public static void loadMatchdayList() {
        for (int i = 0; i <= 34; i++) {
            Map<LocalDate, List<Match>> map = new HashMap<>();

            switch (i) {
                case 1:
                    map.put(
                            LocalDate.of(2022, 8, 5),
                            Arrays.asList(
                                    new Match(Team.SGE, Team.FCB, 1, 1, 6)));
                    map.put(
                            LocalDate.of(2022, 8, 6),
                            Arrays.asList(
                                    new Match(Team.FCU, Team.BSC, 1, 3, 1),
                                    new Match(Team.BMG, Team.TSG, 1, 3, 1),
                                    new Match(Team.WOB, Team.SVW, 1, 2, 2),
                                    new Match(Team.BOC, Team.M05, 1, 1, 2),
                                    new Match(Team.FCA, Team.SCF, 1, 0, 4),
                                    new Match(Team.BVB, Team.B04, 1, 1, 0)));
                    map.put(
                            LocalDate.of(2022, 8, 7),
                            Arrays.asList(
                                    new Match(Team.VfB, Team.RBL, 1, 1, 1),
                                    new Match(Team.KOE, Team.S04, 1, 3, 1)));
                    break;

                case 16:
                    map.put(
                            LocalDate.of(2023, 1, 20),
                            Arrays.asList(
                                    new Match(Team.RBL, Team.FCB, 16, 1, 1)));
                    map.put(
                            LocalDate.of(2023, 1, 21),
                            Arrays.asList(
                                    new Match(Team.FCU, Team.TSG, 16, 3, 1),
                                    new Match(Team.SGE, Team.S04, 16, 3, 0),
                                    new Match(Team.WOB, Team.SCF, 16, 6, 0),
                                    new Match(Team.BOC, Team.BSC, 16, 3, 1),
                                    new Match(Team.VfB, Team.M05, 16, 1, 1),
                                    new Match(Team.KOE, Team.SVW, 16, 7, 1)));
                    map.put(
                            LocalDate.of(2023, 1, 21),
                            Arrays.asList(
                                    new Match(Team.BVB, Team.FCA, 16, 4, 3),
                                    new Match(Team.BMG, Team.B04, 16, 2, 3)));
                    break;

                case 18:
                    map.put(
                            LocalDate.of(2023, 1, 27),
                            Arrays.asList(
                                    new Match(Team.RBL, Team.VfB, 18, "Red Bull Arena")));

                    map.put(
                            LocalDate.of(2023, 1, 28),
                            Arrays.asList(
                                    new Match(Team.SCF, Team.FCA, 18, "Europa-Park Stadion"),
                                    new Match(Team.M05, Team.BOC, 18, "MEWA ARENA"),
                                    new Match(Team.TSG, Team.BMG, 18, "PreZero Arena"),
                                    new Match(Team.BSC, Team.KOE, 18, "Olympiastadion"),
                                    new Match(Team.SVW, Team.WOB, 18, "wohninvest WESERSTADION"),
                                    new Match(Team.FCB, Team.SGE, 18, "Allianz Arena")));

                    map.put(
                            LocalDate.of(2023, 1, 29),
                            Arrays.asList(
                                    new Match(Team.B04, Team.BVB, 18, "BayArena")));
                    break;

                default:
                    break;
            }

            seasonList.add(map);
        }
    }

    public static void loadTeamScores() {
        for (Team team : Team.values()) {
            team.p = 0;
            team.gf = 0;
            team.ga = 0;
            team.w = 0;
            team.d = 0;
            team.l = 0;

            for (Map<LocalDate, List<Match>> map : seasonList) {
                for (List<Match> matches : map.values()) {
                    for (Match match : matches) {
                        if (match.a == team) {
                            team.p++;
                            team.gf += match.aGoals;
                            team.ga += match.bGoals;

                            if (match.aGoals > match.bGoals) {
                                team.w++;
                            } else if (match.aGoals < match.bGoals) {
                                team.l++;
                            }
                        } else if (match.b == team) {
                            team.p++;
                            team.gf += match.bGoals;
                            team.ga += match.aGoals;

                            if (match.aGoals < match.bGoals) {
                                team.w++;
                            } else if (match.aGoals > match.bGoals) {
                                team.l++;
                            }
                        }
                    }
                }
            }

            team.d = team.p - team.w + team.l;
            team.gd = team.gf - team.ga;
            team.pts = team.w * 3 + team.d;
        }
    }

    public static Map<LocalDate, List<Match>> getMatchdayList(int matchday) {
        return seasonList.get(matchday);
    }
}
