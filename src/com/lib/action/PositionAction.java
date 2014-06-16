package com.lib.action;

import com.lib.domain.Position;
import com.lib.service.PositionService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class PositionAction extends ActionSupport {
	private Position position;
	private PositionService positionService;
	private int id;
	
	public String save() {
		String msg = null;
		if (positionService.save(position) == 1) {
			msg = "<span class='label label-success'>添加成功</span>";
		} else {
			msg = "<span class='label label-important'>位置已经存在</span>";
		}
		ActionContext.getContext().put("msg", msg);
		return "success";
	}
	
	public String toEdit() {
		ActionContext.getContext().put("posi", positionService.getById(id));
		return "posiedit";
	}
	
	public String update() {
		ActionContext.getContext().put("posi", positionService.getById(position.getId()));
		if (positionService.updateFloor(position) == 1) {
			ActionContext.getContext().put("msg", "<span class='label label-success'>修改成功</span>");
			return "success";
		} else {
			ActionContext.getContext().put("msg", "<span class='label label-important'>位置已经存在</span>");
			return "posiedit";
		}
	}
	
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPositionService(PositionService positionService) {
		this.positionService = positionService;
	}
}
