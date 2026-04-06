package assignment2.problem2;

import java.util.Objects;

/**
 * This is a mail item class which represent a mail item object with a width, a height, a depth and
 * a recipient
 */
public class MailItem {

  private Integer width;
  private Integer height;
  private Integer depth;
  private Recipient recipient;
  private static final Integer MIN = 1;

  /**
   * Constructor for recipient object with specific first name, last name and email address
   *
   * @param width     - mail's width in inches, an integer greater than or equal to 1
   * @param height    - mail's height in inches, an integer greater than or equal to 1
   * @param depth     - mail's depth in inches, an integer greater than or equal to 1
   * @param recipient - mail's recipient, Recipient class.
   * @throws InvalidSizeException when any of the width, height, depth smaller than 1.
   */
  public MailItem(Integer width, Integer height, Integer depth, Recipient recipient)
      throws InvalidSizeException {
    this.isValidSize(width);
    this.width = width;
    this.isValidSize(height);
    this.height = height;
    this.isValidSize(depth);
    this.depth = depth;
    this.recipient = recipient;
  }

  /**
   * Check whether the given size is large or equal to 1
   *
   * @param size - width, depth or height of mail, integer
   * @throws InvalidSizeException when the given size is smaller than 1
   */
  private void isValidSize(int size) throws InvalidSizeException {
    if (size < MIN) {
      throw new InvalidSizeException("Minimum accepted value is one!");
    }
  }

  /**
   * Returns the width of the mail.
   *
   * @return the width of the mail, integer
   */
  public Integer getWidth() {
    return width;
  }

  /**
   * Returns the height of the mail.
   *
   * @return the height of the mail, integer
   */
  public Integer getHeight() {
    return height;
  }

  /**
   * Returns the depth of the mail.
   *
   * @return the depth of the mail, integer
   */
  public Integer getDepth() {
    return depth;
  }

  /**
   * Returns the recipient of the mail.
   *
   * @return the recipient of the mail, integer
   */
  public Recipient getRecipient() {
    return recipient;
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
    MailItem mailItem = (MailItem) o;
    return width.equals(mailItem.width) && height.equals(mailItem.height) && depth.equals(
        mailItem.depth)
        && recipient.equals(mailItem.recipient);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return Objects.hash(width, height, depth, recipient);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    return "Mail{" +
        "width=" + width +
        ", height=" + height +
        ", depth=" + depth +
        ", recipient=" + recipient +
        '}';
  }
}
