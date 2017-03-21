function  initTable1(path) {
        var table = $('#sample_1');
        //将工具按钮放置表格右上角
        $.extend(true, $.fn.DataTable.TableTools.classes, {
            "container": "btn-group tabletools-dropdown-on-portlet",
            "buttons": {
                "normal": "btn btn-circle default",
                "disabled": "btn btn-circle default disabled"
            },
            "collection": {
                "container": "DTTT_dropdown dropdown-menu tabletools-dropdown-menu"
            }
        });
        var oTable = table.dataTable({
            "language": {
                "aria": {
                    "sortAscending": ": 升序排序",
                    "sortDescending": ": 降序排序"
                },
                "emptyTable": "无数据",
                "info": "显示 _START_ 到 _END_ 共 _TOTAL_ 条数据",
                "infoEmpty": "没有数据",
                "infoFiltered": "(共 _MAX_ 条 )",
                "lengthMenu": "显示 _MENU_条数据",
                "search": "搜索:",
                "zeroRecords": "未找到匹配的数据"
            },
            "order": [
                [0, 'asc']
            ],
            "lengthMenu": [
                [5, 10, 15, 20, -1],
                [5, 10, 15, 20, "全部"] // change per page values here
            ],
            "pageLength": 10,
            "dom": "<'row' <'col-md-12'>><'row'<'col-md-6 col-sm-12'l><'col-md-6 col-sm-12'T>r><'table-scrollable't><'row'<'col-md-5 col-sm-12'i><'col-md-7 col-sm-12'p>>", // horizobtal scrollable datatable
            "ajax": path+"/print/load.do",
            "columns" : [ {
				"data" : "university"
			}, {
				"data" : "college"
			}, {
				"data" : "major"
			}, {
				"data" : "year"
			}, {
				"data" : "classes"
			}, {
				"data" : "snumber"
			}, {
				"data" : "name"
			}, {
				"data" : "sex"
			}, {
				"data" : "address"
			}, {
				"data" : "ethnic"
			} ],
            deferRender: true,
            "tableTools": {
            	"sRowSelect": "single",
                "sSwfPath": path+"/assets/global/plugins/datatables/extensions/TableTools/swf/copy_csv_xls_pdf.swf",
                "aButtons": [{
                    "sExtends": "xls",
                    "sToolTip": "表格数据导出Excel",
                    "sButtonText": "<i class='fa fa-file-excel-o'></i> 导出",
                    "oSelectorOpts": {
                        page: 'current'
                    }
                    
                }, {
                    "sExtends": "print",
                    "sButtonText": "<i class='fa fa-print'></i> 打印",
                    "sToolTip": "打印表格数据",
                    "sInfo": '"CTRL+P"打印,"ESC"退出',
                    "sMessage": "该数据由开发平台提供",
                    "bShowAll": false
                }]
            }
        });
    }