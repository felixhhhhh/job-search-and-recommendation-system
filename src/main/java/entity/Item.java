package entity;

import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

//方法一：偷懒
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Item {
	private String itemId;
	private String name;
	private String address;
	private Set<String> keywords;
	private String imageUrl;
	private String url;
	
	public JSONObject toJSONObject() {
		JSONObject obj = new JSONObject();
		obj.put("item_id", itemId);
		obj.put("name", name);
		obj.put("address", address);
		obj.put("keywords", new JSONArray(keywords));
		obj.put("image_url", imageUrl);
		obj.put("url", url);
		return obj;
	}

}
//方法2：
/*public class Item {
	private String itemId;
	private String name;
	private String address;
	private Set<String> keywords;
	private String imageUrl;
	private String url;
	
	private Item(String itemId, String name, String address, Set<String> keywords, String imageUrl, String url) {
		this.itemId = itemId;
		this.name = name;
		this.address = address;
		this.keywords = keywords;
		this.imageUrl = imageUrl;
		this.url = url;
	} //constructor
	
	//如果每个人要求的初始数据不一样，数量不一样，种类不一样，无法排列组合 -- 用builder pattern
	//builder pattern 在class内定义一个class （内部嵌套类）
	//1.命名定义：是inner class 且是static的
	//2.包括所有的field
	//3.引入field的setter
	//4.定义一个叫做build的方法
	//builder只做初始化
	
	public static class ItermBuilder{  //必须是static，为什么是static
		private String itemId;
		private String name;
		private String address;
		private Set<String> keywords;
		private String imageUrl;
		private String url;
		
		public void setItemId(String itemId) {
			this.itemId = itemId;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public void setKeywords(Set<String> keywords) {
			this.keywords = keywords;
		}
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		
		
		
		private Item(ItemBuilder builder) {
			this.itemId = builder.itemId;
			this.name = builder.name;
			this.address = builder.address;
			this.imageUrl = builder.imageUrl;
			this.url = builder.url;
			this.keywords = builder.keywords;
		}

	}
	
	public String getItemId() {
		return itemId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public Set<String> getKeywords() {
		return keywords;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public String getUrl() {
		return url;
	}
	
	public Item build() {
		return new Item(this); //this 指的builder，指的是调用builder的对象
	}
  } 
	

	
}

//

//ItemBuilder builder = new ItermBuilder();
//builder.setItem("id");
//builder.setname("name");
//Item item = builder.build(); --这行是调用build的，所以this指的是builder，谁调用build() 谁就是this

//builder.setItemId
//目的就是item的初始化不能随便改
*/