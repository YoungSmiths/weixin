package com.wangjing.wechat.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.wangjing.wechat.bean.VerificationCode;
import com.wangjing.wechat.utils.DBCPConnection;
import com.wangjing.wechat.utils.RandomStringUtils;

public class VerificationCodeService {
	public static boolean generateVerificationCode(int size, int length) {
		List<String> codes = RandomStringUtils.getCodes(size, length);
		if (codes.size() != size)
			codes = RandomStringUtils.getCodes(size, length);
		Connection conn = null;
		conn = new DBCPConnection().getConnection();
		if (conn == null) {
			// return "连接数据库失败";
			return false;
		} else {

			try {
				conn.setAutoCommit(false);
				String sql = "INSERT verificationCode(code,isUsed,type,version,startDate,expiredDate,usedDate) VALUES(?,?,?,?,?,?,?)";
				PreparedStatement prest = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				for (String code : codes) {
					prest.setString(1, code);
					prest.setString(2, "fals");
					prest.setString(3, "CASH");
					prest.setString(4, new Date(new java.util.Date().getTime()).toString());
					prest.setLong(5, new java.util.Date().getTime());
					prest.setLong(6, new java.util.Date().getTime());
					prest.setLong(7, new java.util.Date().getTime());
					prest.addBatch();
				}
				prest.executeBatch();
				conn.commit();
			} catch (SQLException ex) {
				System.out.println(ex);
				ex.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return false;
	}

	public static boolean download(String version) {
		Connection conn = null;
		conn = new DBCPConnection().getConnection();
		if (conn == null) {
			// return "连接数据库失败";
			return false;
		} else {

			try {
				String sql = "select * verificationCode where verion = ?";
				PreparedStatement prest = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				prest.setString(1, version);
				ResultSet executeQuery = prest.executeQuery();
				while (executeQuery.next()) {
					String code = executeQuery.getString(1);
					String isUsed = executeQuery.getString(2);
					String type = executeQuery.getString(3);
					System.out.println("code:" + code + "是否使用：" + isUsed + "类型：" + type);
				}
			} catch (SQLException ex) {
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return false;
	}

	public static VerificationCode getVerificationCode(String code) {
		Connection conn = null;
		conn = new DBCPConnection().getConnection();
		if (conn == null) {
			// return "连接数据库失败";
			System.out.println("连接数据库失败");
			return null;
		} else {

			String sql = "select * from verificationcode where code = ?";
			PreparedStatement pstmt;
			try {
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1, code);
				ResultSet executeQuery = pstmt.executeQuery();
				VerificationCode verificationCode = new VerificationCode();
				while (executeQuery.next()) {
					verificationCode.setCode(executeQuery.getString(2));
					verificationCode.setIsUsed(executeQuery.getString(3));
					verificationCode.setType(executeQuery.getString(4));
					verificationCode.setVersion(executeQuery.getString(5));
					verificationCode.setStartDate(executeQuery.getString(6));
					verificationCode.setExpiredDate(executeQuery.getString(7));
					verificationCode.setUsedDate(executeQuery.getString(8));
				}
				return verificationCode;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;

		}
	}
	
	public static boolean setVerificatonCodeUsed(String code) {
		Connection conn = null;
		conn = new DBCPConnection().getConnection();
		if (conn == null) {
			// return "连接数据库失败";
			System.out.println("连接数据库失败");
			return false;
		} else {

			String sql = "update verificationcode set isUsed = 'true' where code = ?";
			PreparedStatement pstmt;
			try {
				pstmt = (PreparedStatement) conn.prepareStatement(sql);
				pstmt.setString(1, code);
				pstmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return false;

		}
	}

	public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}

		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ps = null;
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
}
