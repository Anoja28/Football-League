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
                                    new Match(Team.SGE, Team.FCB, 1, 1, 6, "Deutsche Bank Park")));
                    map.put(
                            LocalDate.of(2022, 8, 6),
                            Arrays.asList(
                                    new Match(Team.FCU, Team.BSC, 1, 3, 1, "Stadion An der Alten Försterei"),
                                    new Match(Team.BMG, Team.TSG, 1, 3, 1, "BORUSSIA-PARK"),
                                    new Match(Team.WOB, Team.SVW, 1, 2, 2, "Volkswagen Arena"),
                                    new Match(Team.BOC, Team.M05, 1, 1, 2, "Vonovia Ruhrstadion"),
                                    new Match(Team.FCA, Team.SCF, 1, 0, 4, "WWK ARENA"),
                                    new Match(Team.BVB, Team.B04, 1, 1, 0, "SIGNAL IDUNA PARK")));
                    map.put(
                            LocalDate.of(2022, 8, 7),
                            Arrays.asList(
                                    new Match(Team.VfB, Team.RBL, 1, 1, 1, "Mercedes-Benz Arena"),
                                    new Match(Team.KOE, Team.S04, 1, 3, 1, "RheinEnergieSTADION")));
                    break;

                case 2:
                    map.put(
                            LocalDate.of(2022, 8, 12),
                            Arrays.asList(
                                    new Match(Team.SCF, Team.BVB, 2, 1, 3,"Europa-Park Stadion")));
                    map.put(
                            LocalDate.of(2022, 8, 13),
                            Arrays.asList(
                                    new Match(Team.B04, Team.FCA, 2, 1, 2,"BayArena"),
                                    new Match(Team.RBL, Team.KOE, 2, 2, 2,"Red Bull Arena"),
                                    new Match(Team.TSG, Team.BOC, 2, 3, 2,"PreZero Arena"),
                                    new Match(Team.BSC, Team.SGE, 2, 1, 1,"Olympiastadion"),
                                    new Match(Team.SVW, Team.VfB, 2, 2, 2,"wohninvest WESERSTADION"),
                                    new Match(Team.S04, Team.BMG, 2, 2, 2,"Veltins-Arena")));
                    map.put(
                            LocalDate.of(2022, 8, 14),
                            Arrays.asList(
                                    new Match(Team.M05, Team.FCU, 2, 0, 0,"MEWA ARENA"),
                                    new Match(Team.FCB, Team.WOB, 2, 2, 0,"Allianz Arena")));
                    break;

                case 3:
                    map.put(
                            LocalDate.of(2022, 8, 19),
                            Arrays.asList(
                                    new Match(Team.BMG, Team.BSC, 3, 1, 0,"BORUSSIA-PARK")));
                    map.put(
                            LocalDate.of(2022, 8, 20),
                            Arrays.asList(
                                    new Match(Team.BVB, Team.SVW, 3, 2, 3,"SIGNAL IDUNA PARK"),
                                    new Match(Team.B04, Team.TSG, 3, 0, 3,"BayArena"),
                                    new Match(Team.WOB, Team.S04, 3, 0, 0,"Volkswagen Arena"),
                                    new Match(Team.FCA, Team.M05, 3, 1, 2,"WWK ARENA"),
                                    new Match(Team.VfB, Team.SCF, 3, 0, 1,"Mercedes-Benz Arena"),
                                    new Match(Team.FCU, Team.RBL, 3, 2, 1,"Stadion An der Alten Försterei")));
                    map.put(
                            LocalDate.of(2022, 8, 21),
                            Arrays.asList(
                                    new Match(Team.SGE, Team.KOE, 3, 1, 1,"Deutsche Bank Park"),
                                    new Match(Team.BOC, Team.FCB, 3, 0, 7,"Vonovia Ruhrstadion")));
                    break;

                case 4:
                    map.put(
                            LocalDate.of(2022, 8, 26),
                            Arrays.asList(
                                    new Match(Team.SCF, Team.BOC, 4, 1, 0,"Europa-Park Stadion")));
                    map.put(
                            LocalDate.of(2022, 8, 27),
                            Arrays.asList(
                                    new Match(Team.RBL, Team.WOB, 4, 2, 0,"Red Bull Arena"),
                                    new Match(Team.M05, Team.B04, 4, 0, 3,"MEWA ARENA"),
                                    new Match(Team.TSG, Team.FCA, 4, 1, 0,"PreZero Arena"),
                                    new Match(Team.BSC, Team.BVB, 4, 0, 1,"Olympiastadion"),
                                    new Match(Team.S04, Team.FCU, 4, 1, 6,"Veltins-Arena"),
                                    new Match(Team.FCB, Team.BMG, 4, 1, 1,"Allianz Arena")));
                    map.put(
                            LocalDate.of(2022, 8, 28),
                            Arrays.asList(
                                    new Match(Team.KOE, Team.VfB, 4, 0, 0,"RheinEnergieSTADION"),
                                    new Match(Team.SVW, Team.SGE, 4, 3, 4,"wohninvest WESERSTADION")));
                    break;

                case 5:
                    map.put(
                            LocalDate.of(2022, 9, 2),
                            Arrays.asList(
                                    new Match(Team.BVB, Team.TSG, 5, 1, 0,"SIGNAL IDUNA PARK")));
                    map.put(
                            LocalDate.of(2022, 9, 3),
                            Arrays.asList(
                                    new Match(Team.B04, Team.SCF, 5, 2, 3,"BayArena"),
                                    new Match(Team.FCU, Team.FCB, 5, 1, 1,"Stadion An der Alten Försterei"),
                                    new Match(Team.WOB, Team.KOE, 5, 2, 4,"Volkswagen Arena"),
                                    new Match(Team.BOC, Team.SVW, 5, 0, 2,"Vonovia Ruhrstadion"),
                                    new Match(Team.VfB, Team.S04, 5, 1, 1,"Mercedes-Benz Arena"),
                                    new Match(Team.SGE, Team.RBL, 5, 4, 0,"Deutsche Bank Park")));
                    map.put(
                            LocalDate.of(2022, 9, 4),
                            Arrays.asList(
                                    new Match(Team.FCA, Team.BSC, 5, 0, 2,"WWK ARENA"),
                                    new Match(Team.BMG, Team.M05, 5, 0, 1,"BORUSSIA-PARK")));
                    break;

                case 6:
                    map.put(
                            LocalDate.of(2022, 9, 9),
                            Arrays.asList(
                                    new Match(Team.SVW, Team.FCA, 6, 0, 1,"wohninvest WESERSTADION")));
                    map.put(
                            LocalDate.of(2022, 9, 10),
                            Arrays.asList(
                                    new Match(Team.FCB, Team.VfB, 6, 2, 2,"Allianz Arena"),
                                    new Match(Team.RBL, Team.BVB, 6, 3, 0,"Red Bull Arena"),
                                    new Match(Team.TSG, Team.M05, 6, 4, 1,"PreZero Arena"),
                                    new Match(Team.SGE, Team.WOB, 6, 0, 1,"Deutsche Bank Park"),
                                    new Match(Team.BSC, Team.B04, 6, 2, 2,"Olympiastadion"),
                                    new Match(Team.S04, Team.BOC, 6, 3, 1,"Veltins-Arena")));
                    map.put(
                            LocalDate.of(2022, 9, 11),
                            Arrays.asList(
                                    new Match(Team.KOE, Team.FCU, 6, 0, 1,"RheinEnergieSTADION"),
                                    new Match(Team.SCF, Team.BMG, 6, 0, 0,"Europa-Park Stadion")));
                    break;

                case 7:
                    map.put(
                            LocalDate.of(2022, 9, 16),
                            Arrays.asList(
                                    new Match(Team.M05, Team.BSC, 7, 1, 1,"MEWA ARENA")));
                    map.put(
                            LocalDate.of(2022, 9, 17),
                            Arrays.asList(
                                    new Match(Team.BVB, Team.S04, 7, 1, 0,"SIGNAL IDUNA PARK"),
                                    new Match(Team.B04, Team.SVW, 7, 1, 1,"BayArena"),
                                    new Match(Team.FCA, Team.FCB, 7, 1, 0,"WWK ARENA"),
                                    new Match(Team.VfB, Team.SGE, 7, 1, 3,"Mercedes-Benz Arena"),
                                    new Match(Team.BMG, Team.RBL, 7, 3, 0,"BORUSSIA-PARK"),
                                    new Match(Team.FCU, Team.WOB, 7, 2, 0,"Stadion An der Alten Försterei")));
                    map.put(
                            LocalDate.of(2022, 9, 18),
                            Arrays.asList(
                                    new Match(Team.BOC, Team.KOE, 7, 1, 1,"Vonovia Ruhrstadion"),
                                    new Match(Team.TSG, Team.SCF, 7, 0, 0,"PreZero Arena")));
                    break;

                case 8:
                    map.put(
                            LocalDate.of(2022, 9, 30),
                            Arrays.asList(
                                    new Match(Team.FCB, Team.B04, 8, 4, 0,"Allianz Arena")));
                    map.put(
                            LocalDate.of(2022, 10, 1),
                            Arrays.asList(
                                    new Match(Team.RBL, Team.BOC, 8, 4, 0,"Red Bull Arena"),
                                    new Match(Team.SCF, Team.M05, 8, 2, 1,"Europa-Park Stadion"),
                                    new Match(Team.KOE, Team.BVB, 8, 3, 2,"RheinEnergieSTADION"),
                                    new Match(Team.SGE, Team.FCU, 8, 2, 0,"Deutsche Bank Park"),
                                    new Match(Team.WOB, Team.VfB, 8, 3, 2,"Volkswagen Arena"),
                                    new Match(Team.SVW, Team.BMG, 8, 5, 1,"wohninvest WESERSTADION")));
                    map.put(
                            LocalDate.of(2022, 10, 2),
                            Arrays.asList(
                                    new Match(Team.BSC, Team.TSG, 8, 1, 1,"Olympiastadion"),
                                    new Match(Team.S04, Team.FCA, 8, 2, 3,"Veltins-Arena")));
                    break;

                case 9:
                    map.put(
                            LocalDate.of(2022, 10, 7),
                            Arrays.asList(
                                    new Match(Team.TSG, Team.SVW, 9, 1, 2,"PreZero Arena")));
                    map.put(
                            LocalDate.of(2022, 10, 8),
                            Arrays.asList(
                                    new Match(Team.B04, Team.S04, 9, 4, 0,"BayArena"),
                                    new Match(Team.M05, Team.RBL, 9, 1, 1,"MEWA ARENA"),
                                    new Match(Team.BOC, Team.SGE, 9, 3, 0,"Vonovia Ruhrstadion"),
                                    new Match(Team.FCA, Team.WOB, 9, 1, 1,"WWK ARENA"),
                                    new Match(Team.BVB, Team.FCB, 9, 2, 2,"SIGNAL IDUNA PARK")));
                    map.put(
                            LocalDate.of(2022, 10, 9),
                            Arrays.asList(
                                    new Match(Team.BMG, Team.KOE, 9, 5, 2,"BORUSSIA-PARK"),
                                    new Match(Team.BSC, Team.SCF, 9, 2, 2,"Olympiastadion"),
                                    new Match(Team.VfB, Team.FCU, 9, 0, 1,"Mercedes-Benz Arena")));
                    break;

                case 10:
                    map.put(
                            LocalDate.of(2022, 10, 14),
                            Arrays.asList(
                                    new Match(Team.S04, Team.TSG, 10, 0, 3,"Veltins-Arena")));
                    map.put(
                            LocalDate.of(2022, 10, 15),
                            Arrays.asList(
                                    new Match(Team.SGE, Team.B04, 10, 5, 1,"Deutsche Bank Park"),
                                    new Match(Team.WOB, Team.BMG, 10, 2, 2,"Volkswagen Arena"),
                                    new Match(Team.VfB, Team.BOC, 10, 4, 1,"Mercedes-Benz Arena"),
                                    new Match(Team.SVW, Team.M05, 10, 0, 2,"wohninvest WESERSTADION"),
                                    new Match(Team.RBL, Team.BSC, 10, 3, 2,"Red Bull Arena")));
                    map.put(
                            LocalDate.of(2022, 10, 16),
                            Arrays.asList(
                                    new Match(Team.KOE, Team.FCA, 10, 3, 2,"RheinEnergieSTADION"),
                                    new Match(Team.FCU, Team.BVB, 10, 2, 0,"Stadion An der Alten Försterei"),
                                    new Match(Team.FCB, Team.SCF, 10, 5, 0,"Allianz Arena")));
                    break;

                case 11:
                    map.put(
                            LocalDate.of(2022, 10, 21),
                            Arrays.asList(
                                    new Match(Team.M05, Team.KOE, 11, 5, 0,"MEWA ARENA")));
                    map.put(
                            LocalDate.of(2022, 10, 22),
                            Arrays.asList(
                                    new Match(Team.BVB, Team.VfB, 11, 5, 0,"SIGNAL IDUNA PARK"),
                                    new Match(Team.B04, Team.WOB, 11, 2, 2,"BayArena"),
                                    new Match(Team.SCF, Team.SVW, 11, 2, 0,"Europa-Park Stadion"),
                                    new Match(Team.TSG, Team.FCB, 11, 0, 2,"PreZero Arena"),
                                    new Match(Team.FCA, Team.RBL, 11, 3, 3,"WWK ARENA"),
                                    new Match(Team.BMG, Team.SGE, 11, 1, 3,"BORUSSIA-PARK")));
                    map.put(
                            LocalDate.of(2022, 10, 23),
                            Arrays.asList(
                                    new Match(Team.BOC, Team.FCU, 11, 2, 1,"Vonovia Ruhrstadion"),
                                    new Match(Team.BSC, Team.S04, 11, 2, 1,"Olympiastadion")));
                    break;

                case 12:
                    map.put(
                            LocalDate.of(2022, 10, 28),
                            Arrays.asList(
                                    new Match(Team.SVW, Team.BSC, 12, 1, 0,"wohninvest WESERSTADION")));
                    map.put(
                            LocalDate.of(2022, 10, 29),
                            Arrays.asList(
                                    new Match(Team.FCB, Team.M05, 12, 6, 2,"Allianz Arena"),
                                    new Match(Team.RBL, Team.B04, 12, 2, 0,"Red Bull Arena"),
                                    new Match(Team.WOB, Team.BOC, 12, 4, 0,"Volkswagen Arena"),
                                    new Match(Team.VfB, Team.FCA, 12, 2, 1,"Mercedes-Benz Arena"),
                                    new Match(Team.SGE, Team.BVB, 12, 1, 2,"Deutsche Bank Park")));
                    map.put(
                            LocalDate.of(2022, 10, 30),
                            Arrays.asList(
                                    new Match(Team.FCU, Team.BMG, 12, 2, 1,"Stadion An der Alten Försterei"),
                                    new Match(Team.S04, Team.SCF, 12, 0, 2,"Veltins-Arena"),
                                    new Match(Team.KOE, Team.TSG, 12, 1, 1,"RheinEnergieSTADION")));
                    break;

                case 13:
                    map.put(
                            LocalDate.of(2022, 11, 4),
                            Arrays.asList(
                                    new Match(Team.BMG, Team.VfB, 13, 3, 1,"BORUSSIA-PARK")));
                    map.put(
                            LocalDate.of(2022, 11, 5),
                            Arrays.asList(
                                    new Match(Team.M05, Team.WOB, 13, 0, 3,"MEWA ARENA"),
                                    new Match(Team.TSG, Team.RBL, 13, 1, 3,"PreZero Arena"),
                                    new Match(Team.FCA, Team.SGE, 13, 1, 2,"WWK ARENA"),
                                    new Match(Team.BSC, Team.FCB, 13, 2, 3,"Olympiastadion"),
                                    new Match(Team.BVB, Team.BOC, 13, 3, 0,"SIGNAL IDUNA PARK"),
                                    new Match(Team.SVW, Team.S04, 13, 2, 1,"wohninvest WESERSTADION")));
                    map.put(
                            LocalDate.of(2022, 11, 6),
                            Arrays.asList(
                                    new Match(Team.B04, Team.FCU, 13, 5, 0,"BayArena"),
                                    new Match(Team.SCF, Team.S04, 13, 2, 0,"Europa-Park Stadion")));
                    break;

                case 14:
                    map.put(
                            LocalDate.of(2022, 11, 8),
                            Arrays.asList(
                                    new Match(Team.WOB, Team.BVB, 14, 2, 0,"Volkswagen Arena"),
                                    new Match(Team.FCB, Team.SVW, 14, 6, 1,"Allianz Arena"),
                                    new Match(Team.BOC, Team.BMG, 14, 2, 1,"Vonovia Ruhrstadion"),
                                    new Match(Team.VfB, Team.BSC, 14, 2, 1,"Mercedes-Benz Arena")));
                    map.put(
                            LocalDate.of(2022, 11, 9),
                            Arrays.asList(
                                    new Match(Team.KOE, Team.B04, 14, 1, 2,"RheinEnergieSTADION"),
                                    new Match(Team.RBL, Team.SCF, 14, 3, 1,"Red Bull Arena"),
                                    new Match(Team.FCU, Team.FCA, 14, 2, 2,"Stadion An der Alten Försterei"),
                                    new Match(Team.SGE, Team.TSG, 14, 4, 2,"Deutsche Bank Park"),
                                    new Match(Team.S04, Team.M05, 14, 1, 0,"Veltins-Arena")));
                    break;

                case 15:
                    map.put(
                            LocalDate.of(2022, 11, 11),
                            Arrays.asList(
                                    new Match(Team.BMG, Team.BVB, 15, 4, 2,"BORUSSIA-PARK")));
                    map.put(
                            LocalDate.of(2022, 11, 12),
                            Arrays.asList(
                                    new Match(Team.B04, Team.VfB, 15, 2, 0,"BayArena"),
                                    new Match(Team.TSG, Team.WOB, 15, 1, 2,"PreZero Arena"),
                                    new Match(Team.FCA, Team.BOC, 15, 0, 1,"WWK ARENA"),
                                    new Match(Team.BSC, Team.KOE, 15, 2, 0,"Olympiastadion"),
                                    new Match(Team.SVW, Team.RBL, 15, 1, 2,"wohninvest WESERSTADION"),
                                    new Match(Team.S04, Team.FCB, 15, 0, 2,"Veltins-Arena")));
                    map.put(
                            LocalDate.of(2022, 11, 13),
                            Arrays.asList(
                                    new Match(Team.M05, Team.SGE, 15, 1, 1,"MEWA ARENA"),
                                    new Match(Team.SCF, Team.FCU, 15, 4, 1,"Europa-Park Stadion")));
                    break;

                case 16:
                    map.put(
                            LocalDate.of(2023, 1, 20),
                            Arrays.asList(
                                    new Match(Team.RBL, Team.FCB, 16, 1, 1, "Red Bull Arena")));
                    map.put(
                            LocalDate.of(2023, 1, 21),
                            Arrays.asList(
                                    new Match(Team.FCU, Team.TSG, 16, 3, 1, "Stadion An der Alten Försterei"),
                                    new Match(Team.SGE, Team.S04, 16, 3, 0, "Deutsche Bank Park"),
                                    new Match(Team.WOB, Team.SCF, 16, 6, 0, "Volkswagen Arena"),
                                    new Match(Team.BOC, Team.BSC, 16, 3, 1, "Vonovia Ruhrstadion"),
                                    new Match(Team.VfB, Team.M05, 16, 1, 1, "Mercedes-Benz Arena"),
                                    new Match(Team.KOE, Team.SVW, 16, 7, 1, "RheinEnergieSTADION")));
                    map.put(
                            LocalDate.of(2023, 1, 22),
                            Arrays.asList(
                                    new Match(Team.BVB, Team.FCA, 16, 4, 3, "SIGNAL IDUNA PARK"),
                                    new Match(Team.BMG, Team.B04, 16, 2, 3, "BORUSSIA-PARK")));
                    break;

                case 17:
                    map.put(
                            LocalDate.of(2023, 1, 24),
                            Arrays.asList(
                                    new Match(Team.S04, Team.RBL, 17, "Veltins-Arena"),
                                    new Match(Team.FCB, Team.KOE, 17, "Allianz Arena"),
                                    new Match(Team.TSG, Team.VfB, 17, "PreZero Arena"),
                                    new Match(Team.BSC, Team.WOB, 17, "Olympiastadion")));

                    map.put(
                            LocalDate.of(2023, 1, 25),
                            Arrays.asList(
                                    new Match(Team.M05, Team.BVB, 17, "MEWA ARENA"),
                                    new Match(Team.B04, Team.BOC, 17, "BayArena"),
                                    new Match(Team.SCF, Team.SGE, 17, "Europa-Park Stadion"),
                                    new Match(Team.FCA, Team.BMG, 17, "WWK ARENA"),
                                    new Match(Team.SVW, Team.FCU, 17, "wohninvest WESERSTADION")));
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
                                    new Match(Team.BSC, Team.FCU, 18, "Olympiastadion"),
                                    new Match(Team.SVW, Team.WOB, 18, "wohninvest WESERSTADION"),
                                    new Match(Team.FCB, Team.SGE, 18, "Allianz Arena")));

                    map.put(
                            LocalDate.of(2023, 1, 29),
                            Arrays.asList(
                                    new Match(Team.S04, Team.KOE, 18, "Veltins-Arena"),
                                    new Match(Team.B04, Team.BVB, 18, "BayArena")));
                    break;

                default:
                    break;
            }

            seasonList.add(map);
        }
    }

    public static void loadTeamScores() {
        System.out.println(Team.FCB.p);
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
