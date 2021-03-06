package ua.model.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TransporterFilter {
	
	private static final Pattern INT_PATTERN = Pattern.compile("^[0-9]{1,10}$");
	
	private static final Pattern DECIMAL_PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})|([0-9]{1,18})$");
	
	private String minRate = "";
	
	private String maxRate = "";
	
	private String minWeight = "";
	
	private String maxWeight = "";
	
	private String minCount = "";
	
	private String maxCount = "";
	
	private String minAge = "";
	
	private String maxAge = "";
	
	private List<String> modelIds = new ArrayList<>();
	
	private List<String> brandIds = new ArrayList<>();
	
	private String  cityId = "";
	

	public String getMinRate() {
		return minRate;
	}

	public void setMinRate(String minRate) {
		if(DECIMAL_PATTERN.matcher(minRate).matches())
		this.minRate = minRate;
	}

	public String getMaxRate() {
		return maxRate;
	}

	public void setMaxRate(String maxRate) {
		if(DECIMAL_PATTERN.matcher(maxRate).matches())
		this.maxRate = maxRate;
	}

	public String getMinWeight() {
		return minWeight;
	}

	public void setMinWeight(String minWeight) {
		if(INT_PATTERN.matcher(minWeight).matches())
		this.minWeight = minWeight;
	}

	public String getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(String maxWeight) {
		if(INT_PATTERN.matcher(maxWeight).matches())
		this.maxWeight = maxWeight;
	}

	public String getMinCount() {
		return minCount;
	}

	public void setMinCount(String minCount) {
		if(INT_PATTERN.matcher(minCount).matches())
		this.minCount = minCount;
	}

	public String getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(String maxCount) {
		if(INT_PATTERN.matcher(maxCount).matches())
		this.maxCount = maxCount;
	}

	public String getMinAge() {
		return minAge;
	}

	public void setMinAge(String minAge) {
		if(INT_PATTERN.matcher(minAge).matches())
		this.minAge = minAge;
	}

	public String getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(String maxAge) {
		if(INT_PATTERN.matcher(maxAge).matches())
		this.maxAge = maxAge;
	}

	public List<String> getModelIds() {
		return modelIds;
	}

	public void setModelIds(List<String> modelIds) {
		this.modelIds = modelIds;
	}

	public List<String> getBrandIds() {
		return brandIds;
	}

	public void setBrandIds(List<String> brandlIds) {
		this.brandIds = brandlIds;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
	
}
