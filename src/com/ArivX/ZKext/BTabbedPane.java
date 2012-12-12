////////////////////////////////////////////////////////////////////////////////
//
// This software copyright ArivX 2012
// This software is open source with no particular license specified.
// Inquiries www.arivx.com
// ArivX, Issaquah, WA 98027
//
////////////////////////////////////////////////////////////////////////////////
//
// FILENAME: BTabbedPane.java
//
// DESCRIPTION: A User Interface Component that supplies the user with a set
//              of named tabs derived from the Tabbox component of ZK This is
//              accomplished by combining one Tab and one TabPanel for each
//              passed in String into a "TabPair". Each "TabPair" is added to
//              Tabs and TabPanels which is added to this Tabbox
//
// USAGE: ArrayList<String> someTabs = new ArrayList<String>(Arrays.asList(TabA, TabB, TabC));
//        BTabbedPane someTabPane = new BTabbedPane(someTabs);
//
// HISTORY:
//  Summer 2012 KBS Initial creation
//
////////////////////////////////////////////////////////////////////////////////
package com.ArivX.ZKext.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.zkoss.zul.Tab;
import org.zkoss.zul.Tabbox;
import org.zkoss.zul.Tabpanel;
import org.zkoss.zul.Tabpanels;
import org.zkoss.zul.Tabs;

/**
 * A User Interface Component that supplies the user with a set of named tabs derived
 * from the Tabbox component of ZK
 * This is accomplished by combining one Tab and one TabPanel for each passed in String
 * into a "TabPair".
 * Each "TabPair" is added to a Tabs and TabPanels which is added to this Tabbox
 * 
 * @author Brad Simmons
 *
 */
public class BTabbedPane extends Tabbox
{

  private static final long serialVersionUID = 1L;
  HashMap<String, Integer> THM;
  private ArrayList<String> _names;
  private ArrayList<Tabpair> _tabs;
  
  /**
   * Constructs a BTabbedPane with tabs named for the strings in the ArrayList
   * 
   * 
   * @param ArrayList<String> -- List of tabs
   * @TODO deal with dups in list
   */
  public BTabbedPane(ArrayList<String> names)
  {
    _names = names;
    this.setStyle("" +
                  "padding-left: 0px; " +
                  "padding-top: 0px; " +
                  "padding-right: 0px; " +
                  "padding-bottom: 0px; " +
                  "");
    
    THM = new HashMap<String, Integer>(_names.size());
    _tabs = new ArrayList<Tabpair>(_names.size());
    
    // It's Tabs
    Tabs Ts = new Tabs();
    Ts.setParent(this);
    // It's Tabpanels
    Tabpanels TPs = new Tabpanels();
    TPs.setParent(this);
      
    Integer index = 0;
    Iterator<String> i = _names.iterator();
    while(i.hasNext())
    {
      String name = i.next();
      
      _tabs.add(new Tabpair(name));
      _tabs.get(index).getTab().setParent(Ts);
      _tabs.get(index).getTabpanel().setParent(TPs);
      
      THM.put(name, index);
      
      index++;
      
    }
    
  }
  
  /**
   * Sets the Label at index to label. 
   * 
   * @param String label
   * @throws  IndexOutOfBoundsException - if index is out of range (index<0 || index>=tab count)
   * 
   */
  public void setLabelAt(Integer index, String label)
  {
    if (index < 0 || index >= _tabs.size())
    {
      throw new IndexOutOfBoundsException("Index " + index + " < 0 || >= " + _tabs.size());
    }
    else
    {
      THM.put(label, index);
      THM.remove(_names.get(index));
      _names.set(index, label);
      getTab(index).setLabel(label);
    }
  }
  
  /*
   * Returns the Tab for the given name
   */
  public Tab getTab(String name)
  {
    return _tabs.get(THM.get(name)).getTab();
  }
  
  /*
   * Returns the Tab for the given index
   */
  public Tab getTab(int index)
  {
    return _tabs.get(index).getTab();
  }
  
  /*
   * Returns the Tabpanel for the given name
   */
  public Tabpanel getTabpanel(String name)
  {
    return _tabs.get(THM.get(name)).getTabpanel();
  }
  
  /*
   * Returns the Tabpanel for the given index
   */
  public Tabpanel getTabpanel(int index)
  {
    return _tabs.get(index).getTabpanel();
  }
  
  
  //////////////////////////////////////////////////////////////////////////////
  // The inner class Tabpair
  //////////////////////////////////////////////////////////////////////////////
  /* Creates a single tab of a tab pane as the combination of a 
   * Tab and a Tabpanel. 
   * 
   */
  private class Tabpair
  {
    Tab tab;
    Tabpanel tabpanel;
    private Tabpair(String name)
    {
      // The Tabs Tabs
      tab = new Tab(name);
      
      // The Tabpanels panels
      tabpanel = new Tabpanel();
      
    }
    
    private Tab getTab()
    {
      return tab;
    }
    
    private Tabpanel getTabpanel()
    {
      return tabpanel;
    }
  }

}
