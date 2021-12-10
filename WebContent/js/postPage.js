
	let editeMode = false;
	let contaner = document.getElementById("contaner");
	
	function editeModeToggle() {
		editeNode = true;
	}
	
	const POST_FORM =   "<h1>${post.title}</h1>"+
						"<span>${post.created}</span>"+
						"<div>${post.description}</div>"+
						"<c:if test='${not empty user && user.id == post.userId}'>"+
							"<a href='/ProjectTest1/edit-post?id=${post.id}'><button>편집 </button></a>"+
							"<form action='delete-post' method='post'><input name='id' value='${post.id}' hidden='true'/><button>삭제</button></form>"+
						"</c:if>";
	
	const EDITE_FORM =  "<form action='edit-post' method='post'>"+
						    "<label>Title:</label></br>"+
							"<input name='title' value='${post.title}' required='required'/></br>"+
							"<label>Description:</label></br>"
							"<textarea name='description' required='required'>${post.description}</textarea></br>"+
							"<button>save</button>"
						"</form>";
	
	if(editeMode) {
		contaner.appendChild(EDITE_FORM);
	} else {
		contaner.appendChild(POST_FORM);
	}
	

alarm("im here");