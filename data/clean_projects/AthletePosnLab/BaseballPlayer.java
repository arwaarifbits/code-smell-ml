package problem1;

/**
 * Class BaseballPlayer os a derived class of Class Athlete contains additional information about
 * team name, average batting, and the number of season home runs.
 */
public class BaseballPlayer extends Athlete {

  private String team;
  private Double averageBatting;
  private Integer seasonHomeRuns;

  /**
   * Constructor for the BaseballPlayer.
   *
   * @param athletesName   - object Name, containing athlete's first, middle and last name
   * @param height         - athlete's height, expressed as a Double in cm (e.g., 6'2'' is recorded
   *                       as 187.96cm)
   * @param weight         - athlete's weigh, expressed as a Double in pounds (e.g. 125, 155, 200
   *                       pounds)
   * @param league         - athelete's league, expressed as String
   * @param team           - baseball player's team, express as a String
   * @param averageBatting - baseball player's average batting score, expressed as a Double
   * @param seasonHomeRuns - baseball player's season home runs, expressed as an Integer
   */
  public BaseballPlayer(Name athletesName, Double height, Double weight,
      String league, String team, Double averageBatting, Integer seasonHomeRuns) {
    super(athletesName, height, weight, league);
    this.team = team;
    this.averageBatting = averageBatting;
    this.seasonHomeRuns = seasonHomeRuns;
  }

  /**
   * Returns the baseball player's team
   *
   * @return The baseball player's team, as String
   */
  public String getTeam() {
    return this.team;
  }

  /**
   * Setter for the baseball player's team
   *
   * @param team The new team, as String
   */
  public void setTeam(String team) {
    this.team = team;
  }

  /**
   * Returns the baseball player's average batting score
   *
   * @return The baseball player's average batting score, as Double
   */
  public Double getAverageBatting() {
    return this.averageBatting;
  }

  /**
   * Setter the baseball player's average batting score
   *
   * @param averageBatting The new average batting score as Double
   */
  public void setAverageBatting(Double averageBatting) {
    this.averageBatting = averageBatting;
  }

  /**
   * Returns the baseball player's season home runs
   *
   * @return the baseball player's season home runs, as Integer
   */
  public Integer getSeasonHomeRuns() {
    return this.seasonHomeRuns;
  }

  /**
   * Sets the baseball player's season home runs
   *
   * @param seasonHomeRuns The new season home runs, as Integer
   */
  public void setSeasonHomeRuns(Integer seasonHomeRuns) {
    this.seasonHomeRuns = seasonHomeRuns;
  }
}
