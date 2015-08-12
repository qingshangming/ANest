package com.yj.anest.entity;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.datatype.BmobRelation;

/**
 * Post字段如下：
	心情帖子表
字段	含义	类型
objectId	String	帖子ID
title	String	帖子标题
content	String	帖子内容
author	Pointer<_User>	帖子作者
likes	Relation<_User>	喜欢帖子的读者
 * @author Administrator
 *
 */
public class Post extends BmobObject {

	private String title;//帖子标题

    private String content;// 帖子内容

    private MyUser author;//帖子的发布者，这里体现的是一对一的关系，该帖子属于某个用户

    private BmobFile image;//帖子图片

    private BmobRelation likes;//多对多关系：用于存储喜欢该帖子的所有用户

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MyUser getAuthor() {
		return author;
	}

	public void setAuthor(MyUser author) {
		this.author = author;
	}

	public BmobFile getImage() {
		return image;
	}

	public void setImage(BmobFile image) {
		this.image = image;
	}

	public BmobRelation getLikes() {
		return likes;
	}

	public void setLikes(BmobRelation likes) {
		this.likes = likes;
	}

	public Post(String title, String content, MyUser author, BmobFile image,
			BmobRelation likes) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
		this.image = image;
		this.likes = likes;
	}

	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Post(String tableName) {
		super(tableName);
		// TODO Auto-generated constructor stub
	}
	
	
}
