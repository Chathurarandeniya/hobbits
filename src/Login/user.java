/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import DatabaseClass.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hashane
 */
public class user {

    DBConnection db = new DBConnection();
    public static int userId;
    public static String playerName;

    public boolean UserLogin(String username, String password) {
        boolean loging = false;
        try {
            ResultSet rst = (ResultSet) db.fetch("Select * from player where  Name='" + username + "'");
            while (rst.next()) {
                userId = rst.getInt("playerId");
                playerName = rst.getString("Name");
                if (password.equals(rst.getString("password"))) {
                    loging = true;
                } else {
                    //
                }
            }
            if (rst.first()) {
            } else {
                loging = false;
                //Login.msg = "Access Denied Invalid UserName!";
                //Login.t.start();
                //Login.y = 1;
            }
            rst.close();
            rst = null;
        } catch (Exception ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loging;
    }

    public void getUserId(String username) {
        try {
            ResultSet rs = (ResultSet) db.fetch("Select * from player where Name='" + username + "'");
            while (rs.next()) {
                userId = rs.getInt("player_id");
            }
            rs.close();
            rs = null;

        } catch (SQLException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
