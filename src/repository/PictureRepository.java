package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.DatabaseConnection;
import dto.Picture;
import utils.DateUtil;

public class PictureRepository {

	private PictureRepository() {
	}

	public static PictureRepository getInstance() {
		return new PictureRepository();
	}

	private Picture toPicture(ResultSet rs) {
		Picture picture = new Picture();
		try {
			picture.setId(rs.getInt("id"));
			picture.setUrl(rs.getString("url"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return picture;
	}

	public ArrayList<Picture> getPostPictures(int postid) {
		ArrayList<Picture> list = new ArrayList<>();
		try (Connection connection = DatabaseConnection.initializeDatabase();
				PreparedStatement ps = connection
						.prepareStatement("SELECT * FROM post_pictures WHERE postid='" + postid + "'");
				ResultSet rs = ps.executeQuery();) {
			while (rs.next())
				list.add(toPicture(rs));
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public void addPicture(Picture picture, int postId) {
		try (Connection connection = DatabaseConnection.initializeDatabase();
				PreparedStatement ps = connection
						.prepareStatement("INSERT INTO post_pictures ( postId, url, created ) VALUES ( '" + postId
								+ "', '" + picture.getUrl() + "','" + DateUtil.getCurrentSqlDate() + "' );");) {
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deletePostPictures(int postid) {
		try (Connection connection = DatabaseConnection.initializeDatabase();
				PreparedStatement ps = connection
						.prepareStatement("DELETE FROM post_pictures WHERE postid='" + postid + "'");) {
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deletePicture(int id) {
		try (Connection connection = DatabaseConnection.initializeDatabase();
				PreparedStatement ps = connection
						.prepareStatement("DELETE FROM post_pictures WHERE id='" + id + "'");) {
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
