package com.helger.security.mac;

import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Nonnull;
import javax.crypto.Mac;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.io.stream.WrappedOutputStream;
import com.helger.commons.string.ToStringGenerator;

/**
 * A transparent stream that updates the associated Mac using the bits going
 * through the stream.
 * <p>
 * To complete the Mac computation, call one of the <code>doFinal</code> methods
 * on the associated message digest after your calls to one of this digest
 * output stream's {@link #write(int) write} methods.
 * <p>
 * It is possible to turn this stream on or off (see {@link #setOn(boolean)
 * on}). When it is on, a call to one of the {@code write} methods results in an
 * update on the message digest. But when it is off, the message digest is not
 * updated. The default is for the stream to be on.
 *
 * @author Philip Helger
 * @since 9.1.7
 */
public class MacOutputStream extends WrappedOutputStream
{
  public static final boolean DEFAULT_ON = true;

  private boolean m_bOn = DEFAULT_ON;

  /**
   * The Mac associated with this stream.
   */
  private Mac m_aMac;

  /**
   * Creates a digest output stream, using the specified output stream and
   * message digest.
   *
   * @param aOS
   *        the output stream.
   * @param aMac
   *        the Mac to associate with this stream.
   */
  public MacOutputStream (@Nonnull final OutputStream aOS, @Nonnull final Mac aMac)
  {
    super (aOS);
    setMac (aMac);
  }

  /**
   * Returns the Mac associated with this stream.
   *
   * @return the Mac associated with this stream.
   * @see #setMac(Mac)
   */
  public final Mac getMac ()
  {
    return m_aMac;
  }

  /**
   * Associates the specified Mac with this stream.
   *
   * @param aMac
   *        the Mac to be associated with this stream. May not be
   *        <code>null</code>.
   * @see #getMac()
   */
  public final void setMac (@Nonnull final Mac aMac)
  {
    ValueEnforcer.notNull (aMac, "Mac");
    m_aMac = aMac;
  }

  /**
   * Updates the Mac (if the function is on) using the specified byte, and in
   * any case writes the byte to the output stream. That is, if the digest
   * function is on (see {@link #setOn(boolean) on}), this method calls
   * <code>update</code> on the message digest associated with this stream,
   * passing it the byte {@code b}. This method then writes the byte to the
   * output stream, blocking until the byte is actually written.
   *
   * @param b
   *        the byte to be used for updating and writing to the output stream.
   * @exception IOException
   *            if an I/O error occurs.
   * @see Mac#update(byte)
   */
  @Override
  public void write (final int b) throws IOException
  {
    out.write (b);
    if (m_bOn)
    {
      m_aMac.update ((byte) b);
    }
  }

  /**
   * Updates the Mac (if the function is on) using the specified subarray, and
   * in any case writes the subarray to the output stream. That is, if the
   * digest function is on (see {@link #setOn(boolean) on}), this method calls
   * <code>update</code> on the Mac associated with this stream, passing it the
   * subarray specifications. This method then writes the subarray bytes to the
   * output stream, blocking until the bytes are actually written.
   *
   * @param aBuf
   *        the array containing the subarray to be used for updating and
   *        writing to the output stream.
   * @param nOfs
   *        the offset into {@code b} of the first byte to be updated and
   *        written.
   * @param nLen
   *        the number of bytes of data to be updated and written from
   *        {@code b}, starting at offset {@code off}.
   * @exception IOException
   *            if an I/O error occurs.
   * @see Mac#update(byte[], int, int)
   */
  @Override
  public void write (final byte [] aBuf, final int nOfs, final int nLen) throws IOException
  {
    out.write (aBuf, nOfs, nLen);
    if (m_bOn)
    {
      m_aMac.update (aBuf, nOfs, nLen);
    }
  }

  /**
   * Turns the function on or off. The default is on. When it is on, a call to
   * one of the {@code write} methods results in an update on the Mac. But when
   * it is off, the Mac is not updated.
   *
   * @param bOn
   *        <code>true</code> to turn the function on, <code>false</code> to
   *        turn it off.
   */
  public final void setOn (final boolean bOn)
  {
    m_bOn = bOn;
  }

  public final boolean isOn ()
  {
    return m_bOn;
  }

  @Override
  public String toString ()
  {
    return ToStringGenerator.getDerived (super.toString ()).append ("Mac", m_aMac).append ("On", m_bOn).getToString ();
  }
}
