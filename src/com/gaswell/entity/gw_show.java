package com.gaswell.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CREATE TABLE `oil_work`.`gw_show` ( `id` INT NOT NULL, `name` VARCHAR(45)
 * NULL, `time` VARCHAR(45) NULL, `power_voltage` VARCHAR(45) NULL,
 * `oil_voltage` VARCHAR(45) NULL, `tao_voltage` VARCHAR(45) NULL,
 * `land_voltage` VARCHAR(45) NULL, `temperature` VARCHAR(45) NULL, `yd_flow`
 * VARCHAR(45) NULL, `total_flow` VARCHAR(45) NULL, `nstantaneous_flow`
 * VARCHAR(45) NULL, `switch_status` VARCHAR(45) NULL, PRIMARY KEY (`id`));
 * 
 * @author canglangwenyue
 * 
 */

@Entity
@Table(name = "gw_show")
public class gw_show {

	private int id;
	private String name;
	private String time;
	private String power_voltage;
	private String oil_voltage;
	private String tao_voltage;
	private String land_voltage;
	private String temperature;
	private String yd_flow;
	private String total_flow;
	private String nstantaneous_flow;
	private String switch_status;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPower_voltage() {
		return power_voltage;
	}

	public void setPower_voltage(String power_voltage) {
		this.power_voltage = power_voltage;
	}

	public String getOil_voltage() {
		return oil_voltage;
	}

	public void setOil_voltage(String oil_voltage) {
		this.oil_voltage = oil_voltage;
	}

	public String getTao_voltage() {
		return tao_voltage;
	}

	public void setTao_voltage(String tao_voltage) {
		this.tao_voltage = tao_voltage;
	}

	public String getLand_voltage() {
		return land_voltage;
	}

	public void setLand_voltage(String land_voltage) {
		this.land_voltage = land_voltage;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getYd_flow() {
		return yd_flow;
	}

	public void setYd_flow(String yd_flow) {
		this.yd_flow = yd_flow;
	}

	public String getTotal_flow() {
		return total_flow;
	}

	public void setTotal_flow(String total_flow) {
		this.total_flow = total_flow;
	}

	public String getNstantaneous_flow() {
		return nstantaneous_flow;
	}

	public void setNstantaneous_flow(String nstantaneous_flow) {
		this.nstantaneous_flow = nstantaneous_flow;
	}

	public String getSwitch_status() {
		return switch_status;
	}

	public void setSwitch_status(String switch_status) {
		this.switch_status = switch_status;
	}

}
