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
// FILENAME: BStackableHeader.java
//
// DESCRIPTION:
//  A multi layered header for use with Grid
//
// USAGE:
//
// HISTORY:
//  Summer 2012 KBS Initial creation
//
//////////////////////////////////////////////////////////////////////
package com.ArivX.ZKext.components.headers;

import java.util.logging.Logger;

import org.zkoss.zul.Columns;
import org.zkoss.zul.Grid;


/**
 * A BStackableHeader takes a Grid and prepares it for adding one or more header rows. 
 * It does this by creating a Columns object and then setting the parent passed in Grid
 * as the parent of the Columns object.
 * Subsequent calls to addHeaderRow(BHeaderRow) "stack" header rows from the top down.
 * 
 * @author Brad Simmons
 *
 */
public class BStackableHeader
{
  private Grid _grid;
  
  Logger theLog = Logger.getLogger("com.ArivX.SRP");

  /**
   * Creates a stackable header object for the passed in Grid
   * 
   * @param the Grid which needs a header
   */
  public BStackableHeader(Grid grid)
  {
    theLog.fine("ENTERING");
    _grid = grid;
    theLog.fine("EXITING");

    
  }
  
  /**
   * Stacks the passed in row from the top down where <br>
   * BStackableHeader.addHeaderRow(BHeaderRow1)<br>
   * BStackableHeader.addHeaderRow(BHeaderRow2)<br>
   * would produce <br>
   * ----------------------------------------------------- <br>
   *  BHeaderRow1                                          <br>
   * ----------------------------------------------------- <br>
   *  BHeaderRow2                                          <br>
   * ----------------------------------------------------- <br>
   *                                                       <br>
   *  Grid                                                 <br>
   *                                                       <br>
   * ----------------------------------------------------- <br>
   * 
   * @param row
   */
  public void addHeaderRow(BHeaderRow row)
  {
    theLog.fine("ENTERING");
    row.setParent(_grid);
    theLog.fine("EXITING");
  }
  
  /**
   * This adds the columns header row to the grid. The object Columns must be present
   * in order to realize the Auxhead rows added in this class by addHeaderRow(BHeaderRow).
   * Columns is bit of a misnomer for the name of the passed in object. It is really the 
   * header for the Columns created by the Grid. 
   * Stacks the passed in column row from the top down where <br>
   * BStackableHeader.addHeaderRow(BHeaderRow1)<br>
   * BStackableHeader.addCoumnsHeaderRow(Columns)<br>
   * would produce <br>
   * ----------------------------------------------------- <br>
   *  BHeaderRow1                                          <br>
   * ----------------------------------------------------- <br>
   *  Columns                                              <br>
   * ----------------------------------------------------- <br>
   *                                                       <br>
   *  Grid                                                 <br>
   *                                                       <br>
   * ----------------------------------------------------- <br>
   *  
   * @param c
   */
  public void addColumnsHeaderRow(Columns c)
  {
    theLog.fine("ENTERING");
    c.setParent(_grid);
    theLog.fine("EXITING");
  }
  
  /**
   * Adds a set of default Columns to the passed in Grid.
   * Columns is bit of a misnomer for the name of the created object. It is really the 
   * header for the Columns created by the Grid. 
   * Stacks the passed in column row from the top down where <br>
   * BStackableHeader.addHeaderRow(BHeaderRow1)<br>
   * BStackableHeader.addDefaultColumnsHeaderRow()<br>
   * would produce <br>
   * ----------------------------------------------------- <br>
   *  BHeaderRow1                                          <br>
   * ----------------------------------------------------- <br>
   *  Columns                                              <br>
   * ----------------------------------------------------- <br>
   *                                                       <br>
   *  Grid                                                 <br>
   *                                                       <br>
   * ----------------------------------------------------- <br>
   *  
   */
  public void addDefaultColumnsHeaderRow()
  {
    theLog.fine("ENTERING");
    Columns cols = _grid.getColumns();
    if (null == cols)
    {
      cols = new Columns();
      cols.setParent(_grid);
    }
    theLog.fine("EXITING");
  }

}
