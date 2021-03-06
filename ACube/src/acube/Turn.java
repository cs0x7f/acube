package acube;

import java.util.EnumSet;

public enum Turn {
  U1, U2, U3, D1, D2, D3, F1, F2, F3, B1, B2, B3, L1, L2, L3, R1, R2, R3, /**/
  u1, u2, u3, d1, d2, d3, f1, f2, f3, b1, b2, b3, l1, l2, l3, r1, r2, r3, /**/
  E1, E2, E3, S1, S2, S3, M1, M2, M3, e1, e2, e3, s1, s2, s3, m1, m2, m3;
  private static int[] isB = {//
      1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, /**/
      1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, /**/
      1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
  private static String[] names = (//
      "U U2 U' D D2 D' F F2 F' B B2 B' L L2 L' R R2 R' " + /**/
      "u u2 u' d d2 d' f f2 f' b b2 b' l l2 l' r r2 r' " + /**/
      "E E2 E' S S2 S' M M2 M' e e2 e' s s2 s' m m2 m'").split(" ");
  public static final Turn[] values = values();
  public static final int size = values.length;
  public static final EnumSet<Turn> valueSet = EnumSet.allOf(Turn.class);
  public static final EnumSet<Turn> essentialValueSet = EnumSet.of(//
      U1, U2, U3, D1, D2, D3, F1, F2, F3, B1, B2, B3, L1, L2, L3, R1, R2, R3, E1, E2, E3, S1, S2, S3, M1, M2, M3);
  public static final EnumSet<Turn> essentialValueSetB = EnumSet.of(//
      U1, U2, U3, D1, D2, D3, F2, B2, L2, R2, E1, E2, E3, S2, M2);

  public static Turn turn(final int turn) {
    return values()[turn];
  }

  private static boolean isB(final int turn) {
    return isB[turn] > 0;
  }

  public static EnumSet<Turn> getValidB(final EnumSet<Turn> turns) {
    final EnumSet<Turn> turnsB = EnumSet.copyOf(turns);
    for (final Turn turn : turns)
      if (!turn.isB())
        turnsB.remove(turn);
    return turnsB;
  }

  public boolean isB() {
    return isB(ordinal());
  }

  @Override
  public String toString() {
    return names[ordinal()];
  }
}
