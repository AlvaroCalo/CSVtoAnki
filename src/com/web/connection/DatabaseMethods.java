package com.web.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public final class DatabaseMethods {

	public static int setLastPair() {

		int lastPair = -1;

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "SELECT Id FROM `word_pairs` WHERE CSV = 0 LIMIT 1";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// Iterating the result
			if (rs.next()) {
				lastPair = rs.getInt(1);
			}

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
		}

		Dataconn.closeConn(conn);

		return lastPair;
	}

	public static String setFirstWord(int id) {

		String firstWord = "NotFound";

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "SELECT words.Word FROM words JOIN word_pairs ON words.Id = word_pairs.Word1 WHERE word_pairs.Id = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			// The next line are the parameters
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			// Iterating the result
			if (rs.next()) {
				firstWord = rs.getString(1);
			}

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
		}

		Dataconn.closeConn(conn);

		return firstWord;

	}

	public static String setSecondWord(int id) {

		String secondWord = "NotFound";

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "SELECT words.Word FROM words JOIN word_pairs ON words.Id = word_pairs.Word2 WHERE word_pairs.Id = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			// The next line are the parameters
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			// Iterating the result
			if (rs.next()) {
				secondWord = rs.getString(1);
			}

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
		}

		Dataconn.closeConn(conn);

		return secondWord;

	}

	public static int returnWordId(String word) {

		int id = -1;
		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "SELECT Id FROM `words` WHERE Word = ? LIMIT 1  ";

		try {
			pstmt = conn.prepareStatement(sql);
			// The next line are the parameters
			pstmt.setString(1, word);
			rs = pstmt.executeQuery();
			// Iterating the result
			if (rs.next()) {
				id = rs.getInt(1);
			}

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
		}

		Dataconn.closeConn(conn);

		return id;
	}

	public static ArrayList<String> returnIpaList(int id) {
		ArrayList<String> list = new ArrayList<String>();

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "SELECT IPA FROM `data_words` WHERE Words_Id = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			// The next line are the parameters
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String item;
				item = rs.getString(1);
				list.add(item);
			}

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
		}

		Dataconn.closeConn(conn);

		return list;
	}

	public static ArrayList<String> returnSoundList(int id) {
		ArrayList<String> list = new ArrayList<String>();

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "SELECT Sound FROM `data_words` WHERE Words_Id = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			// The next line are the parameters
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String item;
				item = rs.getString(1);
				list.add(item);
			}

			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (pstmt != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					rs.close();
				} catch (SQLException logIgnore) {
				}
		}

		Dataconn.closeConn(conn);

		return list;
	}

	public static boolean setLastPairCSV() {
		int lastPairId = -1;
		lastPairId = setLastPair();
		
		boolean success = false;

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "UPDATE word_pairs SET CSV = 1 WHERE Id =" + lastPairId;

		try {
			pstmt = conn.prepareStatement(sql);

			if (pstmt.executeUpdate() > 0) {
				success = true;
			}

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException logIgnore) {
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);

		} finally {

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException logIgnore) {
				}
		}

		Dataconn.closeConn(conn);

		return success;
	}

	public static boolean discardLastPairCSV() {
		int lastPairId = -1;
		lastPairId = setLastPair();
		
		boolean success = false;

		// Connection variables
		Connection conn = null;
		PreparedStatement pstmt = null;

		// Calling the connection
		conn = Dataconn.conn();

		String sql = "UPDATE word_pairs SET CSV = 2 WHERE Id =" + lastPairId;

		try {
			pstmt = conn.prepareStatement(sql);

			if (pstmt.executeUpdate() > 0) {
				success = true;
			}

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException logIgnore) {
				}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);

		} finally {

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException logIgnore) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException logIgnore) {
				}
		}

		Dataconn.closeConn(conn);

		return success;
	}

	
}

//SELECT i.Id, i.Pair_num, u1.Word, u2.Word
//FROM word_pairs i
//JOIN words u1 ON u1.Id = i.Word1
//JOIN words u2 ON u2.Id = i.Word2
//WHERE i.Pair_Num = 'pair:27'