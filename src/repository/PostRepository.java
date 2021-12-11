package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import connection.DatabaseConnection;
import dto.Post;
import utils.DateUtil;

public class PostRepository {

	private PostRepository() {
	}

	public static PostRepository getInstance() {
		return new PostRepository();
	}

	private Post toPost(ResultSet rs) throws ParseException, SQLException {
		Post post = new Post();
		post.setId(rs.getInt("idpost"));
		post.setTitle(rs.getString("title"));
		post.setDescription(rs.getString("description"));
		post.setUserId(rs.getInt("user_id"));
		Date date1 = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).parse(rs.getString("created"));
		post.setCreated(date1);
		return post;
	}

	public ArrayList<Post> getAllPosts() {
		ArrayList<Post> allposts = new ArrayList<>();
		try (Connection connection = DatabaseConnection.initializeDatabase();
				PreparedStatement ps = connection
						.prepareStatement("SELECT * FROM post WHERE deleted is null ORDER BY idpost DESC");
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				allposts.add(toPost(rs));
			}
		} catch (ParseException | SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return allposts;
	}

	public Post getPostByID(int id) {
		try (Connection connection = DatabaseConnection.initializeDatabase();
				PreparedStatement ps = connection.prepareStatement("SELECT * FROM post WHERE idpost='" + id + "'");
				ResultSet rs = ps.executeQuery();) {
			if (rs.next())
				return toPost(rs);
		} catch (SQLException | ParseException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void addPost(Post post) {
		try (Connection connection = DatabaseConnection.initializeDatabase();
				PreparedStatement ps = connection
						.prepareStatement("INSERT INTO post (title, description, created, user_id) VALUES ('"
								+ post.getTitle() + "','" + post.getDescription() + "','" + DateUtil.getCurrentSqlDate()
								+ "', '" + post.getUserId() + "')");) {
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updatePost(Post post) {
		try (Connection connection = DatabaseConnection.initializeDatabase();
				PreparedStatement ps = connection.prepareStatement("UPDATE testdb.post SET title = '" + post.getTitle()
						+ "', description = '" + post.getDescription() + "', updated='" + DateUtil.getCurrentSqlDate()
						+ "' WHERE idpost='" + post.getId() + "'");) {
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deletePostById(int id) {
		try (Connection connection = DatabaseConnection.initializeDatabase();
				PreparedStatement ps = connection.prepareStatement(
						"UPDATE post SET deleted ='" + DateUtil.getCurrentSqlDate() + "' WHERE idpost='" + id + "'");) {
			ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
