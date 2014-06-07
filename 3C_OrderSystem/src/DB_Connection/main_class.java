/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_Connection;

import Create_Tables.Address_Table;
import Create_Tables.Items_Table;
import Create_Tables.Orders_Table;
import java.io.IOException;
import Msg_Displays.*;

/**
 *
 * @author Bella Belova
 */
public class main_class {

    public static void main(String[] argv) throws IOException, Address_Table.TableException, Orders_Table.TableException, Items_Table.TableException
    {
        MenuShow main_menu;
        main_menu = new MenuShow();
        main_menu.MenuRun();
        
    }
}
