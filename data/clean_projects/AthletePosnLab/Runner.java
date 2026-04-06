package problem1;

/**
 * Class Runner os a derived class of Class Athlete contains additional information about the best
 * 5K time, the best half-marathon time and favorite running event
 */
public class Runner extends Athlete {

  private Double best5KTime;
  private Double bestHalfMarathonTime;
  private String favoriteRunningEvent;

  /**
   * Constructs a new Runner, based upon all of the provided input parameters.
   *
   * @param athletesName         - athlete's name, encoded as a data type Name
   * @param height               - athlete's height, stored as a Double
   * @param weight               - athlete's weight, stored as a Double
   * @param league               - baseball player's league, stored as a String
   * @param best5KTime           - The Runner's best time in 5 kilometers, expressed as a Double
   * @param bestHalfMarathonTime - The Runner's best time in half-marathon, expressed as a Double
   * @param favoriteRunningEvent - The Runner's favorite running event, expressed as a String
   */
  public Runner(Name athletesName, Double height, Double weight, String league, Double best5KTime,
      Double bestHalfMarathonTime, String favoriteRunningEvent) {
    super(athletesName, height, weight, league);
    this.best5KTime = best5KTime;
    this.bestHalfMarathonTime = bestHalfMarathonTime;
    this.favoriteRunningEvent = favoriteRunningEvent;
  }


  /**
   * Returns the Runner's best time in 5 kilometers
   *
   * @return the Runner's best time in 5 kilometers, as Double
   */
  public Double getBest5KTime() {
    return best5KTime;
  }

  /**
   * Setter for Runner's best time in 5 kilometers
   *
   * @param best5KTime - Runner's best time in 5 kilometers, encoded as Double
   */
  public void setBest5KTime(Double best5KTime) {
    this.best5KTime = best5KTime;
  }

  /**
   * Returns the Runner's best half-marathon time
   *
   * @return the Runner's best half-marathon time, as Double
   */
  public Double getBestHalfMarathonTime() {
    return bestHalfMarathonTime;
  }

  /**
   * Setter for Runner's best half-marathon time
   *
   * @param bestHalfMarathonTime - Runner's best half-marathon time, encoded as Double
   */
  public void setBestHalfMarathonTime(Double bestHalfMarathonTime) {
    this.bestHalfMarathonTime = bestHalfMarathonTime;
  }

  /**
   * Returns the Runner's favorite running event
   *
   * @return the Runner's favorite running event, as String
   */
  public String getFavoriteRunningEvent() {
    return favoriteRunningEvent;
  }

  /**
   * Setter for Runner's favorite running event
   *
   * @param favoriteRunningEvent - Runner's favorite running event, encoded as String
   */
  public void setFavoriteRunningEvent(String favoriteRunningEvent) {
    this.favoriteRunningEvent = favoriteRunningEvent;
  }

}
