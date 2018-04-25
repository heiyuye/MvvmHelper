package com.liucr.mvvmhelperdemo.mode;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by liucr on 2018/4/25.
 */
public class Book implements Serializable {
    /**
     * rating : {"max":10,"numRaters":8109,"average":"8.7","min":0}
     * subtitle :
     * author : ["钱锺书"]
     * pubdate : 2002-5
     * tags : [{"count":2865,"name":"钱钟书","title":"钱钟书"},{"count":1290,"name":"小说","title":"小说"},{"count":979,"name":"钱锺书","title":"钱锺书"},{"count":967,"name":"中国文学","title":"中国文学"},{"count":488,"name":"中国","title":"中国"},{"count":479,"name":"文学","title":"文学"},{"count":440,"name":"幽默","title":"幽默"},{"count":380,"name":"短篇小说","title":"短篇小说"}]
     * origin_title :
     * image : https://img3.doubanio.com/view/subject/m/public/s1069022.jpg
     * binding : 平装
     * translator : []
     * catalog : 序
     * 1 上帝的梦
     * 2 猫
     * 3 灵感
     * 4 纪念
     * 附录 《写在人生边上》和《人・兽・鬼》重印本序
     * pages : 123
     * images : {"small":"https://img3.doubanio.com/view/subject/s/public/s1069022.jpg","large":"https://img3.doubanio.com/view/subject/l/public/s1069022.jpg","medium":"https://img3.doubanio.com/view/subject/m/public/s1069022.jpg"}
     * alt : https://book.douban.com/subject/1058679/
     * id : 1058679
     * publisher : 生活·读书·新知三联书店
     * isbn10 : 7108016850
     * isbn13 : 9787108016850
     * title : 人·兽·鬼
     * url : https://api.douban.com/v2/book/1058679
     * alt_title :
     * author_intro : 钱钟书，原名仰先，字哲良，字默存，号槐聚，曾用笔名中书君，中国现代著名作家、文学研究家。曾为《毛泽东选集》英文版翻译小组成员。晚年就职于中国社会科学院，任副院长。书评家夏志清先生认为小说《围城》是“中国近代文学中最有趣、最用心经营的小说，可能是最伟大的一部”。钱钟书在文学，国故，比较文学，文化批评等领域的成就，推崇者甚至冠以“钱学”。其夫人杨绛也是著名作家。
     * summary : 《人·兽·鬼》包括《上帝的梦》、《猫》、《灵感》、《纪念》四部短篇小说。
     * series : {"id":"47","title":"钱锺书集"}
     * price : 10.00元
     */

    @SerializedName("rating")
    private RatingModel rating;
    @SerializedName("subtitle")
    private String subtitle;
    @SerializedName("pubdate")
    private String pubdate;
    @SerializedName("origin_title")
    private String originTitle;
    @SerializedName("image")
    private String image;
    @SerializedName("binding")
    private String binding;
    @SerializedName("catalog")
    private String catalog;
    @SerializedName("pages")
    private String pages;
    @SerializedName("images")
    private ImagesModel images;
    @SerializedName("alt")
    private String alt;
    @SerializedName("id")
    private String id;
    @SerializedName("publisher")
    private String publisher;
    @SerializedName("isbn10")
    private String isbn10;
    @SerializedName("isbn13")
    private String isbn13;
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;
    @SerializedName("alt_title")
    private String altTitle;
    @SerializedName("author_intro")
    private String authorIntro;
    @SerializedName("summary")
    private String summary;
    @SerializedName("series")
    private SeriesModel series;
    @SerializedName("price")
    private String price;
    @SerializedName("author")
    private List<String> author;
    @SerializedName("tags")
    private List<TagsModel> tags;
    @SerializedName("translator")
    private List<?> translator;

    public RatingModel getRating() {
        return rating;
    }

    public void setRating(RatingModel rating) {
        this.rating = rating;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getOriginTitle() {
        return originTitle;
    }

    public void setOriginTitle(String originTitle) {
        this.originTitle = originTitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public ImagesModel getImages() {
        return images;
    }

    public void setImages(ImagesModel images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAltTitle() {
        return altTitle;
    }

    public void setAltTitle(String altTitle) {
        this.altTitle = altTitle;
    }

    public String getAuthorIntro() {
        return authorIntro;
    }

    public void setAuthorIntro(String authorIntro) {
        this.authorIntro = authorIntro;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public SeriesModel getSeries() {
        return series;
    }

    public void setSeries(SeriesModel series) {
        this.series = series;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getAuthor() {
        return author;
    }

    public void setAuthor(List<String> author) {
        this.author = author;
    }

    public List<TagsModel> getTags() {
        return tags;
    }

    public void setTags(List<TagsModel> tags) {
        this.tags = tags;
    }

    public List<?> getTranslator() {
        return translator;
    }

    public void setTranslator(List<?> translator) {
        this.translator = translator;
    }

    @Override
    public String toString() {
        return "Book{" +
                "rating=" + rating +
                ", subtitle='" + subtitle + '\'' +
                ", pubdate='" + pubdate + '\'' +
                ", originTitle='" + originTitle + '\'' +
                ", image='" + image + '\'' +
                ", binding='" + binding + '\'' +
                ", catalog='" + catalog + '\'' +
                ", pages='" + pages + '\'' +
                ", images=" + images +
                ", alt='" + alt + '\'' +
                ", id='" + id + '\'' +
                ", publisher='" + publisher + '\'' +
                ", isbn10='" + isbn10 + '\'' +
                ", isbn13='" + isbn13 + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", altTitle='" + altTitle + '\'' +
                ", authorIntro='" + authorIntro + '\'' +
                ", summary='" + summary + '\'' +
                ", series=" + series +
                ", price='" + price + '\'' +
                ", author=" + author +
                ", tags=" + tags +
                ", translator=" + translator +
                '}';
    }

    public static class RatingModel {
        /**
         * max : 10
         * numRaters : 8109
         * average : 8.7
         * min : 0
         */

        @SerializedName("max")
        private int max;
        @SerializedName("numRaters")
        private int numRaters;
        @SerializedName("average")
        private String average;
        @SerializedName("min")
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getNumRaters() {
            return numRaters;
        }

        public void setNumRaters(int numRaters) {
            this.numRaters = numRaters;
        }

        public String getAverage() {
            return average;
        }

        public void setAverage(String average) {
            this.average = average;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        @Override
        public String toString() {
            return "RatingModel{" +
                    "max=" + max +
                    ", numRaters=" + numRaters +
                    ", average='" + average + '\'' +
                    ", min=" + min +
                    '}';
        }
    }

    public static class ImagesModel {
        /**
         * small : https://img3.doubanio.com/view/subject/s/public/s1069022.jpg
         * large : https://img3.doubanio.com/view/subject/l/public/s1069022.jpg
         * medium : https://img3.doubanio.com/view/subject/m/public/s1069022.jpg
         */

        @SerializedName("small")
        private String small;
        @SerializedName("large")
        private String large;
        @SerializedName("medium")
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        @Override
        public String toString() {
            return "ImagesModel{" +
                    "small='" + small + '\'' +
                    ", large='" + large + '\'' +
                    ", medium='" + medium + '\'' +
                    '}';
        }
    }

    public static class SeriesModel {
        /**
         * id : 47
         * title : 钱锺书集
         */

        @SerializedName("id")
        private String id;
        @SerializedName("title")
        private String title;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "SeriesModel{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }

    public static class TagsModel {
        /**
         * count : 2865
         * name : 钱钟书
         * title : 钱钟书
         */

        @SerializedName("count")
        private int count;
        @SerializedName("name")
        private String name;
        @SerializedName("title")
        private String title;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "TagsModel{" +
                    "count=" + count +
                    ", name='" + name + '\'' +
                    ", title='" + title + '\'' +
                    '}';
        }
    }
}
