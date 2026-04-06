package assignment2.problem2;

import java.util.Objects;

/**
 * This is a Locker class which represent a locker object with a max width, a max height, a max
 * depth and a mail item storing in the locker.
 */
public class Locker {

  private Integer maxWidth;
  private Integer maxHeight;
  private Integer maxDepth;
  private MailItem mailItem;
  private final static Integer MIN = 1;

  /**
   * Constructor for locker object with specific max width, max height, max depth and mail item.
   * When a locker is first created, the mail item is null.
   *
   * @param maxWidth  - A maximum width in inches, an integer greater than or equal to 1
   * @param maxHeight - A maximum height in inches, an integer greater than or equal to 1
   * @param maxDepth  - A maximum depth in inches, an integer greater than or equal to 1
   * @throws InvalidSizeException when any of the maxWidth, maxHeight, maxDepth smaller than 1.
   */
  public Locker(Integer maxWidth, Integer maxHeight, Integer maxDepth) throws InvalidSizeException {
    this.isValidMaxSize(maxWidth);
    this.maxWidth = maxWidth;
    this.isValidMaxSize(maxHeight);
    this.maxHeight = maxHeight;
    this.isValidMaxSize(maxDepth);
    this.maxDepth = maxDepth;
    this.mailItem = null;
  }

  /**
   * Check whether the given max size is large or equal to 1
   *
   * @param maxSize - maxWidth, maxDepth or maxHeight of locker, integer
   * @throws InvalidSizeException when the given max size is smaller than 1
   */
  private void isValidMaxSize(int maxSize) throws InvalidSizeException {
    if (maxSize < MIN) {
      throw new InvalidSizeException("Minimum accepted value is one!");
    }
  }

  /**
   * Check whether the locker is occupied.
   *
   * @throws OccupiedException when the mail item is not Null.
   */
  private void isFree() throws OccupiedException {
    if (this.mailItem != null) {
      throw new OccupiedException("The locker is occupied!");
    }
  }

  /**
   * Check whether the mail item's size is valid.
   *
   * @param mail - the mail item is added into the locker, MailItem class
   * @throws ExceedsSizeException when the mail item exceeds the dimensions of the locker
   */
  private void isValidMail(MailItem mail) throws ExceedsSizeException {
    Integer width = mail.getWidth();
    Integer height = mail.getHeight();
    Integer depth = mail.getDepth();
    if (width > this.maxWidth || height > this.maxHeight || depth > this.maxDepth) {
      throw new ExceedsSizeException("The mail item exceeds the dimensions of the locker!");
    }
  }

  /**
   * Store a mail in a locker
   *
   * @param mail - the mail item is added into the locker, MailItem class
   * @throws OccupiedException    when the mail item is not Null.
   * @throws ExceedsSizeException when the mail item exceeds the dimensions of the locker
   */
  public void addMail(MailItem mail) throws OccupiedException, ExceedsSizeException {
    this.isFree();
    this.isValidMail(mail);
    this.mailItem = mail;
  }

  /**
   * Check whether the locker is empty.
   *
   * @throws EmptyException when the mail item is Null.
   */
  private void isOccupied() throws EmptyException {
    if (this.mailItem == null) {
      throw new EmptyException("The locker is empty!");
    }
  }

  /**
   * Check whether the recipient matches the recipient of the mail item.
   *
   * @param recipient - recipient who is going to pick up the mail, Recipient class.
   * @throws MismatchException when the recipient mismatches the recipient of the mail item.
   */
  private void isValidRecipient(Recipient recipient) throws MismatchException {
    if (!recipient.equals(this.mailItem.getRecipient())) {
      throw new MismatchException("Wrong Recipient!");
    }
  }

  /**
   * Remove and return the mail item from the locker with given recipient
   *
   * @param recipient - recipient who is going to pick up the mail, Recipient class.
   * @return the mail item matching the recipient from the locker
   * @throws EmptyException    when the mail item is null.(The locker is empty.)
   * @throws MismatchException when the recipient mismatches the recipient of the mail item.
   */
  public MailItem pickupMail(Recipient recipient) throws EmptyException, MismatchException {
    this.isOccupied();
    this.isValidRecipient(recipient);
    MailItem pickedMail = this.mailItem;
    this.mailItem = null;
    return pickedMail;
  }


  /**
   * Returns the max width of the locker.
   *
   * @return the max width of the locker. Integer.
   */
  public Integer getMaxWidth() {
    return this.maxWidth;
  }

  /**
   * Returns the max height of the locker.
   *
   * @return the max height of the locker. Integer.
   */
  public Integer getMaxHeight() {
    return this.maxHeight;
  }

  /**
   * Returns the max depth of the locker
   *
   * @return the max depth of the locker. Integer.
   */
  public Integer getMaxDepth() {
    return this.maxDepth;
  }

  /**
   * Returns the mail item of the locker
   *
   * @return the mail item of the locker. MailItem class.
   */
  public MailItem getMailItem() {
    return this.mailItem;
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
    Locker locker = (Locker) o;
    return maxWidth.equals(locker.maxWidth) && maxHeight.equals(locker.maxHeight)
        && maxDepth.equals(
        locker.maxDepth) && mailItem.equals(locker.mailItem);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(maxWidth, maxHeight, maxDepth, mailItem);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Locker{" +
        "maxWidth=" + maxWidth +
        ", maxHeight=" + maxHeight +
        ", maxDepth=" + maxDepth +
        ", mailItem=" + mailItem +
        '}';
  }
}
