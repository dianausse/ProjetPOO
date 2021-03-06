package compMaker.model;

public class Match {

  public int scoreEquipe1;
  public int scoreEquipe2;
  public Equipes equipe1;
  public Equipes equipe2;
  public int tour = 0;
  public boolean aEuLieux = false;

  public Match() {
    this.equipe1 = null;
    this.equipe2 = null;
  }

  public Match(Equipes equipe1, Equipes equipe2, int score1, int score2, int tour, boolean bool) {
    this.scoreEquipe1 = score1;
    this.scoreEquipe2 = score2;
    this.equipe1 = equipe1;
    this.equipe2 = equipe2;
    this.tour = tour;
    this.aEuLieux = bool;
  }

  public void putScore(int a, int b) {
    this.scoreEquipe1 = a;
    this.scoreEquipe2 = b;
  }

  public String afficherDate(int a, int b, int c) { // permet de calculer la date d'un match
    int jourTemp = a;
    int moisTemp = b;
    int anneeTemp = c;
    int i = this.tour + a;
    int maxjour = 30;
    int jourAnnee = 365;
    while (i > 0) {
      boolean aBisextil = (((anneeTemp % 100 == 0) || (anneeTemp % 4 == 0)) && (anneeTemp % 400 != 0));
      if (aBisextil) {
        jourAnnee = 366;
      } else {
        jourAnnee = 365;
      }
      if ((moisTemp == 1) || (moisTemp == 3) || (moisTemp == 5) || (moisTemp == 7) || (moisTemp == 8)
          || (moisTemp == 10) || (moisTemp == 12)) {
        maxjour = 31;
      } else if ((moisTemp == 2) && aBisextil) {
        maxjour = 29;
      } else if ((moisTemp == 2) && !aBisextil) {
        maxjour = 28;
        jourAnnee = 365;
      }
      if (i > jourAnnee) {
        i -= jourAnnee;
        anneeTemp++;
      } else if (i > maxjour) {
        i -= maxjour;
        moisTemp = ((moisTemp) % 12) + 1;
        if (moisTemp == 1) {
          anneeTemp++;
        }
      } else {
        jourTemp = i;
        i -= i;
      }
    }
    return (jourTemp + "/" + moisTemp + "/" + anneeTemp);
  }
}