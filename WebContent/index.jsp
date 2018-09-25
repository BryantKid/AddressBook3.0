<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<base href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()%>/" />
<link href="http://libs.baidu.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>通讯录</title>
</head>

<body>
	<br>
	<div style="width:800px; margin:0 auto;" >	
	<form class="form-inline">
  	<div class="form-group">
    	<div class="input-group">    
    		<input  type="text" id="search"  style="width:720px;"onkeyup="searchContacts(this.value)"
    		placeholder="查询联系人" class="form-control" aria-describedby="helpBlock2" >
     	</div>
 	 </div>
 	 <button data-toggle="modal" data-size="modal-lg"
		data-target="#addContacts"  class="btn btn-default" style="float:right"><strong>添加</strong></button>
</form>
	<br>
	<table id="informationTable" class="table table-striped table-bordered table-hover" ></table>
	
	</div>
							
	<div class="modal fade" id="addContacts">
		<div class="modal-dialog">
			<div class="modal-content">

				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h4 class="modal-title">添加联系人</h4>
				</div>
				<div class="modal-body">
					<div class="form-horizontal">

						<div class="form-group">
							<label class="col-sm-2 control-label">姓名</label>
							<div class="col-sm-10">
								<input type="text" class="form-control front-no-box-shadow"
									id="name">
							</div>
						</div>

						<div class="form-group">
							<label class="col-sm-2 control-label">电话</label>
							<div class="col-sm-10">
								<input type="text" class="form-control front-no-box-shadow"
									id="phoneNum">
							</div>
						</div>

					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-default" data-dismiss="modal">取消</button>
					<button class="btn btn-primary" onclick="addContacts()">完成</button>
				</div>

			</div>
		</div>
	</div>


	<script src="http://apps.bdimg.com/libs/jquery/1.11.1/jquery.js"></script>
	<script src="http://libs.baidu.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
	<script src="js/index.js" charset="utf-8"></script>
</body>
</html>