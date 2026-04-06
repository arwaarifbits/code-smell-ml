package problem1;

import java.util.Objects;

/**
 * This is an abstract Specialist class which is the subclass of the AbstractService with two
 * additional field numberOfLicensed and isComplex Represent the Specialist Service.
 */
public abstract class Specialist extends AbstractService {

  private Integer numberOfLicensed;
  private boolean isComplex;
  private final static Integer MIN_LICENSED = 1;
  private final static Integer MIN_COMPLEX_SMALL_MEDIUM_LICENSED = 2;
  private final static Integer MIN_COMPLEX_LARGE_LICENSED = 3;
  private final static Integer BASE = 200;

  /**
   * Constructor for Specialist with propertyAddress, propertySize, carriedOutMonthly,
   * numberOfLicensed and isComplex
   *
   * @param propertyAddress   - the property address, represented as a String
   * @param propertySize      - the property size, represented as an enum
   * @param carriedOutMonthly - whether the service is carried out monthly, represented as boolean
   * @param numberOfServices  - The number of services previously carried out at the address,
   *                          represented as an Integer
   * @param numberOfLicensed  - the number of licensed workers, represented as Integer
   * @param isComplex         - whether the service is complex, represented as boolean
   * @throws InvalidNumberOfLicensedException when number of licensed workers out of range
   */
  public Specialist(String propertyAddress, PropertySize propertySize, boolean carriedOutMonthly,
      int numberOfServices, int numberOfLicensed, boolean isComplex)
      throws InvalidNumberOfLicensedException {
    super(propertyAddress, propertySize, carriedOutMonthly, numberOfServices);
    this.isComplex = isComplex;
    this.numberOfLicensed = this.isValidLicensed(numberOfLicensed);
  }

  /**
   * Get the minimum licensed workers requirement based on isComplex and propertySize. All
   * specialist services require at least one licensed employee. Complex work requires at least 2
   * employees if the house is small or medium size, and at least 3 if the house is large.
   *
   * @return minimum licensed workers, Integer
   */
  private Integer getMinLicensedRequirement() {
    if (this.isComplex == true) {
      if (this.getPropertySize() == PropertySize.LARGE) {
        return MIN_COMPLEX_LARGE_LICENSED;
      }
      return MIN_COMPLEX_SMALL_MEDIUM_LICENSED;
    }
    return MIN_LICENSED;
  }

  /**
   * Check whether the given number of licensed worker is valid If a new complex specialist service
   * is created that not meet these minimum requirements, increase the number of licensed workers to
   * meet the requirement.
   *
   * @param numberOfLicensed - the number of licensed worker
   * @return valid numberOfLicensed, integer
   * @throws InvalidNumberOfLicensedException when number of licensed workers out of range
   */
  protected Integer isValidLicensed(int numberOfLicensed) throws InvalidNumberOfLicensedException {
    if (numberOfLicensed < this.getMinLicensedRequirement()) {
      return this.getMinLicensedRequirement();
    }
    return numberOfLicensed;
  }

  /**
   * Calculate the base fee based on the base price per licensed worker and the number of licensed
   * worker
   *
   * @return the calculated base fee, double
   */
  @Override
  public double calculateBaseFee() {
    return BASE * this.numberOfLicensed;
  }

  /**
   * Calculate the discount fee. All the specialist services do not have discount
   *
   * @return zero, double
   */
  @Override
  public double calculateDiscountFee() {
    return 0;
  }

  /**
   * Return the number of licensed workers
   *
   * @return numberOfLicensed, integer
   */
  public Integer getNumberOfLicensed() {
    return this.numberOfLicensed;
  }

  /**
   * Return whether the service is complex
   *
   * @return isComplex, boolean
   */
  public boolean isComplex() {
    return this.isComplex;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Specialist that = (Specialist) o;
    return isComplex == that.isComplex && numberOfLicensed.equals(that.numberOfLicensed);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), numberOfLicensed, isComplex);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return super.toString() +
        "numberOfLicensed=" + numberOfLicensed +
        ", isComplex=" + isComplex;
  }
}
