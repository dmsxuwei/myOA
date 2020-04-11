$('#start').linkbutton({
			iconCls : 'icon-reload'
		}).unbind("click").click(function() {
			var selRows = $('#tasktb').datagrid('getChecked');
			if (selRows[0].state == '进行中') {
				$.messager.alert('Warning', '进行中');
				return;
			}
			if (selRows[0].state == '已完成') {
				$.messager.alert('Warning', '已完成');
				return;
			}

			//alert(selRows[0].unittestid);
			$.ajax({
				url : 'startTask.do',
				type : 'post',//提交的方式
				dataType : 'json',
				async : false,
				data : {
					id : selRows[0].taskid,
					style : 1
				},
				success : function(msg) {
					// alert(msg[0].result);
					// location.reload("getUnittest.do");
					// $("#center").load('toTask.do');
					doSearch();
				}
			});
		});

		$('#complete').linkbutton({
			iconCls : 'icon-cut'
		}).unbind("click").click(function() {
			var selRows = $('#tasktb').datagrid('getChecked');
			if (selRows[0].state == '未开始') {
				$.messager.alert('Warning', '未开始');
				return;
			}
			if (selRows[0].state == '已完成') {
				$.messager.alert('Warning', '已完成');
				return;
			}

			$.messager.confirm('Confirm', 'Are you sure you want to complete task?', function(r) {
				if (r) {
					$.ajax({
						url : 'startTask.do',
						type : 'post',//提交的方式
						dataType : 'json',
						async : false,
						data : {
							id : selRows[0].taskid,
							style : 2
						},
						success : function(msg) {
							// alert(msg[0].result);
							// location.reload("getUnittest.do");
							// $("#center").load('toTask.do');
							doSearch();
						}
					});
				} else {
					return;
				}

			});
			//alert(selRows[0].unittestid);

		});
