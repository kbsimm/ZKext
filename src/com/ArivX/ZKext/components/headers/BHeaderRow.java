//////////////////////////////////////////////////////////////////////
//
// This software copyright ArivX 2012.
// This software is open source with no particular license specified.
// Inquiries www.arivx.com
// ArivX, Issaquah, WA 98027
//
//////////////////////////////////////////////////////////////////////
//
//
// FILENAME: BHeaderRow.java
//
// DESCRIPTION:
//  A single header row for use with BStackableHeader
//
// USAGE:
//
// HISTORY:
//  Summer 2012 KBS Initial creation
//
//////////////////////////////////////////////////////////////////////
package com.ArivX.ZKext.components.headers;

import org.zkoss.zul.Auxhead;
import org.zkoss.zul.Auxheader;

/**
 * A Auxhead row of Auxheader elements. 
 * A BHeader row is a single row of column header elements (Auxheader objects) which are created with calls
 * to this.addColumnHeader. It may be placed on an object that can have an Auxhead object or it can be part
 * of a multi row header when placed on a BStackableHeader.
 * Auxhead rows are closely tied with Column objects when used with objects like Grid. Column objects must
 * be explicitly attached to the Grid in order for Auxhead rows (and this BHeaderRow) to be visible. 
 * 
 * @author Brad Simmons
 *
 */
public class BHeaderRow extends Auxhead
{

  /**
   * Add the provided Auxheader as a item in this header by calling
   * Auxheader.setParent(this)
   * 
   * @param AuxHeader to be added
   */
  public void addColumnHeader(Auxheader ah)
  {
    ah.setParent(this);
  }
  
  /**
   * A string representation of the item to be added to this header by calling
   * Auxheader.setParent(this)
   * 
   * @param s - A String to be a header
   */
  public void addColumnHeader(String s)
  {
    addColumnHeader(s, 1, 1);
  }
  
  /**
   * A string representation of the item to be added to this header by calling
   * Auxheader.setParent(this) and the number of rows and columns to span
   * 
   * @param s - A String to be a header
   * @param rowSpan - The number of rows to span
   * @param colSpan - The number of columns to span
   */
  public void addColumnHeader(String s, int rowSpan, int colSpan)
  {
    addColumnHeader(s, rowSpan, colSpan, "border: 1px solid;");
  }
  
  /**
   * A string representation of the item to be added to this header by calling
   * Auxheader.setParent(this) and the number of rows and columns to span
   * 
   * @param s - A String to be a header
   * @param rowSpan - The number of rows to span
   * @param colSpan - The number of columns to span
   */
  public void addColumnHeader(String s, int rowSpan, int colSpan, String style)
  {
    Auxheader ah = new Auxheader(s);
    ah.setRowspan(rowSpan);
    ah.setColspan(colSpan);
    ah.setZclass("Non_Existant_Class");
    ah.setAlign("Center");
    ah.setStyle(style);
    
    addColumnHeader(ah);
    
  }
  
}
