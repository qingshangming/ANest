package com.yj.anest.entity;

import cn.bmob.v3.BmobObject;

/**
 * Comment字段如下：
	评论表
字段	含义	类型
objectId	String	评论ID
content	String	评论内容
post	Pointer	评论对应的帖子
author	Pointer<_User>	评论该帖子的人
 * @author Administrator
 *
 */
public class Comment extends BmobObject{
	private String content;//评论内容  

    private MyUser user;//评论的用户，Pointer类型，一对一关系

    private Post post; //所评论的帖子，这里体现的是一对多的关系，一个评论只能属于一个微博

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public MyUser getUser() {
		return user;
	}

	public void setUser(MyUser user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Comment(String content, MyUser user, Post post) {
		super();
		this.content = content;
		this.user = user;
		this.post = post;
	}

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(String tableName) {
		super(tableName);
		// TODO Auto-generated constructor stub
	}
    
}
