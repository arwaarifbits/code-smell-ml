package problem1;

/**
 * Vehicle is a simple object that has a unique Vehicle Identification Number (VIN), corresponding
 * license plate and its owner
 */
public class Vehicle {

  private Integer vin;
  private String licensePlate;
  private Owner owner;

  /**
   * Constructor that creates a new vehicle object with the specified VIN and license plate.
   *
   * @param vin          - VIN of the new Vehicle object.
   * @param licensePlate - license plate of the new Vehicle object.
   * @param owner        - Owner of the new Vehicle object
   */
  public Vehicle(final Integer vin, final String licensePlate, final Owner owner) {
    this.vin = vin;
    this.licensePlate = licensePlate;
    this.owner = owner;
  }

  /**
   * Returns the VIN of the Vehicle.
   *
   * @return the vin of the Vehicle.
   */
  public Integer getVIN() {
    return this.vin;
  }

  /**
   * Returns the licensePlate of the Vehicle.
   *
   * @return the licensePlate of the Vehicle.
   */
  public String getLicensePlate() {
    return this.licensePlate;
  }

  /**
   * Returns the owner's firstName of the Vehicle.
   *
   * @return the owner's firstName of the Vehicle.
   */
  public String getOwnerFirstName() {
    return this.owner.getFirstName();
  }

  /**
   * Returns the owner's lastName of the Vehicle.
   *
   * @return the owner's lastName of the Vehicle.
   */
  public String getOwnerLastName() {
    return this.owner.getLastName();
  }

  /**
   * Returns the owner's phoneNumber of the Vehicle.
   *
   * @return the owner's phoneNumber of the Vehicle.
   */
  public String getOwnerPhoneNumber() {
    return this.owner.getPhoneNumber();
  }

  /**
   * Sets the VIN of the Vehicle.
   *
   * @param vin - the VIN of the Vehicle.
   */
  public void setVIN(final Integer vin) {
    this.vin = vin;
  }

  /**
   * Sets the licensePlate of the Vehicle.
   *
   * @param licensePlate - the licensePlate of the Vehicle.
   */
  public void setLicensePlate(final String licensePlate) {
    this.licensePlate = licensePlate;
  }

  /**
   * Sets the firstName of the Vehicle' owner.
   *
   * @param firstName - the firstName of the Vehicle' owner.
   */
  public void setOwnerFirstName(final String firstName) {
    this.owner.setFirstName(firstName);
  }


  /**
   * Sets the lastName of the Vehicle' owner.
   *
   * @param lastName - the lastName of the Vehicle' owner.
   */
  public void setOwnerLastName(final String lastName) {
    this.owner.setLastName(lastName);
  }

  /**
   * Sets the phoneNumber of the Vehicle's owner.
   *
   * @param phoneNumber - the phoneNumber of the Vehicle' owner.
   */
  public void setOwnerPhoneNumber(final String phoneNumber) {
    this.owner.setPhoneNumber(phoneNumber);
  }

}
