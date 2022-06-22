package com.finvivir.pruebaeibg.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Modelo de datos de la tabla
 *
 * @author Edgar Ivan Barrera
 */
@Entity
@Table(name = "t_weather")
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "lon")
    private BigDecimal lon;

    @Column(name = "lat")
    private BigDecimal lat;

    @Column(name = "id_w")
    private Long id_w;

    @Column(name = "main")
    private String main;

    @Column(name = "description")
    private String description;

    @Column(name = "icon")
    private String icon;

    @Column(name = "base")
    private String base;

    @Column(name = "temp")
    private BigDecimal temp;

    @Column(name = "feels_like")
    private BigDecimal feels_like;

    @Column(name = "temp_min")
    private BigDecimal temp_min;

    @Column(name = "temp_max")
    private BigDecimal temp_max;

    @Column(name = "pressure")
    private BigDecimal pressure;

    @Column(name = "humidity")
    private BigDecimal humidity;

    @Column(name = "sea_level")
    private BigDecimal sea_level;

    @Column(name = "grnd_level")
    private BigDecimal grnd_level;

    @Column(name = "visibility")
    private BigDecimal visibility;

    @Column(name = "speed")
    private BigDecimal speed;

    @Column(name = "deg")
    private BigDecimal deg;

    @Column(name = "gust")
    private BigDecimal gust;

    @Column(name = "all_clouds")
    private BigDecimal all_clouds;

    @Column(name = "dt")
    private BigDecimal dt;

    @Column(name = "country")
    private String country;

    @Column(name = "sunrise")
    private BigDecimal sunrise;

    @Column(name = "sunset")
    private BigDecimal sunset;

    @Column(name = "timezone")
    private BigDecimal timezone;

    @Column(name = "openId", unique = true)
    private Long openId;

    @Column(name = "name")
    private String name;

    @Column(name = "cod")
    private Integer cod;

    @Column(name = "consults")
    private Integer consults;

    @Column(name = "dateAdd")
    @Temporal(TemporalType.TIMESTAMP)
    public Date dateAdd;

    @Column(name = "dateUpdate")
    public Date dateUpdate;


    public Date getDateAdd() {
        return dateAdd;
    }

    public void setDateAdd(Date dateAdd) {
        this.dateAdd = dateAdd;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public Long getId_w() {
        return id_w;
    }

    public void setId_w(Long id_w) {
        this.id_w = id_w;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public BigDecimal getTemp() {
        return temp;
    }

    public void setTemp(BigDecimal temp) {
        this.temp = temp;
    }

    public BigDecimal getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(BigDecimal feels_like) {
        this.feels_like = feels_like;
    }

    public BigDecimal getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(BigDecimal temp_min) {
        this.temp_min = temp_min;
    }

    public BigDecimal getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(BigDecimal temp_max) {
        this.temp_max = temp_max;
    }

    public BigDecimal getPressure() {
        return pressure;
    }

    public void setPressure(BigDecimal pressure) {
        this.pressure = pressure;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public void setHumidity(BigDecimal humidity) {
        this.humidity = humidity;
    }

    public BigDecimal getSea_level() {
        return sea_level;
    }

    public void setSea_level(BigDecimal sea_level) {
        this.sea_level = sea_level;
    }

    public BigDecimal getGrnd_level() {
        return grnd_level;
    }

    public void setGrnd_level(BigDecimal grnd_level) {
        this.grnd_level = grnd_level;
    }

    public BigDecimal getVisibility() {
        return visibility;
    }

    public void setVisibility(BigDecimal visibility) {
        this.visibility = visibility;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public BigDecimal getDeg() {
        return deg;
    }

    public void setDeg(BigDecimal deg) {
        this.deg = deg;
    }

    public BigDecimal getGust() {
        return gust;
    }

    public void setGust(BigDecimal gust) {
        this.gust = gust;
    }

    public BigDecimal getAll_clouds() {
        return all_clouds;
    }

    public void setAll_clouds(BigDecimal all_clouds) {
        this.all_clouds = all_clouds;
    }

    public BigDecimal getDt() {
        return dt;
    }

    public void setDt(BigDecimal dt) {
        this.dt = dt;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getSunrise() {
        return sunrise;
    }

    public void setSunrise(BigDecimal sunrise) {
        this.sunrise = sunrise;
    }

    public BigDecimal getSunset() {
        return sunset;
    }

    public void setSunset(BigDecimal sunset) {
        this.sunset = sunset;
    }

    public BigDecimal getTimezone() {
        return timezone;
    }

    public void setTimezone(BigDecimal timezone) {
        this.timezone = timezone;
    }

    public Long getOpenId() {
        return openId;
    }

    public void setOpenId(Long openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getConsults() {
        return consults;
    }

    public void setConsults(Integer consults) {
        this.consults = consults;
    }
}
