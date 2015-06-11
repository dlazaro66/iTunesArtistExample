package com.dlazaro66.itunesartistsexample.data;


import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

/**
 * @description POJO representing retreived data from iTunes REST Api
 * Generated thanks to jsonschema2pojo.org website
 */
public class ITunesWebServiceArtistResponse {

    public static final String WRAPPER_TYPE_ARTIST = "artist";
    public static final String WRAPPER_TYPE_COLLECTION = "collection";

    @Expose
    private int resultCount;
    @Expose
    private List<Result> results = new ArrayList<Result>();

    /**
     * @return The resultCount
     */
    public int getResultCount() {
        return resultCount;
    }

    /**
     * @param resultCount The resultCount
     */
    public void setResultCount(int resultCount) {
        this.resultCount = resultCount;
    }

    public ITunesWebServiceArtistResponse withResultCount(int resultCount) {
        this.resultCount = resultCount;
        return this;
    }

    /**
     * @return The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     * @param results The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    public ITunesWebServiceArtistResponse withResults(List<Result> results) {
        this.results = results;
        return this;
    }


    protected class Result {

        @Expose
        private String wrapperType;
        @Expose
        private String artistType;
        @Expose
        private String artistName;
        @Expose
        private String artistLinkUrl;
        @Expose
        private int artistId;
        @Expose
        private int amgArtistId;
        @Expose
        private String primaryGenreName;
        @Expose
        private int primaryGenreId;
        @Expose
        private String radioStationUrl;
        @Expose
        private String collectionType;
        @Expose
        private int collectionId;
        @Expose
        private String collectionName;
        @Expose
        private String collectionCensoredName;
        @Expose
        private String artistViewUrl;
        @Expose
        private String collectionViewUrl;
        @Expose
        private String artworkUrl60;
        @Expose
        private String artworkUrl100;
        @Expose
        private double collectionPrice;
        @Expose
        private String collectionExplicitness;
        @Expose
        private int trackCount;
        @Expose
        private String copyright;
        @Expose
        private String country;
        @Expose
        private String currency;
        @Expose
        private String releaseDate;
        @Expose
        private String contentAdvisoryRating;

        /**
         * @return The wrapperType
         */
        public String getWrapperType() {
            return wrapperType;
        }

        /**
         * @param wrapperType The wrapperType
         */
        public void setWrapperType(String wrapperType) {
            this.wrapperType = wrapperType;
        }

        public Result withWrapperType(String wrapperType) {
            this.wrapperType = wrapperType;
            return this;
        }

        /**
         * @return The artistType
         */
        public String getArtistType() {
            return artistType;
        }

        /**
         * @param artistType The artistType
         */
        public void setArtistType(String artistType) {
            this.artistType = artistType;
        }

        public Result withArtistType(String artistType) {
            this.artistType = artistType;
            return this;
        }

        /**
         * @return The artistName
         */
        public String getArtistName() {
            return artistName;
        }

        /**
         * @param artistName The artistName
         */
        public void setArtistName(String artistName) {
            this.artistName = artistName;
        }

        public Result withArtistName(String artistName) {
            this.artistName = artistName;
            return this;
        }

        /**
         * @return The artistLinkUrl
         */
        public String getArtistLinkUrl() {
            return artistLinkUrl;
        }

        /**
         * @param artistLinkUrl The artistLinkUrl
         */
        public void setArtistLinkUrl(String artistLinkUrl) {
            this.artistLinkUrl = artistLinkUrl;
        }

        public Result withArtistLinkUrl(String artistLinkUrl) {
            this.artistLinkUrl = artistLinkUrl;
            return this;
        }

        /**
         * @return The artistId
         */
        public int getArtistId() {
            return artistId;
        }

        /**
         * @param artistId The artistId
         */
        public void setArtistId(int artistId) {
            this.artistId = artistId;
        }

        public Result withArtistId(int artistId) {
            this.artistId = artistId;
            return this;
        }

        /**
         * @return The amgArtistId
         */
        public int getAmgArtistId() {
            return amgArtistId;
        }

        /**
         * @param amgArtistId The amgArtistId
         */
        public void setAmgArtistId(int amgArtistId) {
            this.amgArtistId = amgArtistId;
        }

        public Result withAmgArtistId(int amgArtistId) {
            this.amgArtistId = amgArtistId;
            return this;
        }

        /**
         * @return The primaryGenreName
         */
        public String getPrimaryGenreName() {
            return primaryGenreName;
        }

        /**
         * @param primaryGenreName The primaryGenreName
         */
        public void setPrimaryGenreName(String primaryGenreName) {
            this.primaryGenreName = primaryGenreName;
        }

        public Result withPrimaryGenreName(String primaryGenreName) {
            this.primaryGenreName = primaryGenreName;
            return this;
        }

        /**
         * @return The primaryGenreId
         */
        public int getPrimaryGenreId() {
            return primaryGenreId;
        }

        /**
         * @param primaryGenreId The primaryGenreId
         */
        public void setPrimaryGenreId(int primaryGenreId) {
            this.primaryGenreId = primaryGenreId;
        }

        public Result withPrimaryGenreId(int primaryGenreId) {
            this.primaryGenreId = primaryGenreId;
            return this;
        }

        /**
         * @return The radioStationUrl
         */
        public String getRadioStationUrl() {
            return radioStationUrl;
        }

        /**
         * @param radioStationUrl The radioStationUrl
         */
        public void setRadioStationUrl(String radioStationUrl) {
            this.radioStationUrl = radioStationUrl;
        }

        public Result withRadioStationUrl(String radioStationUrl) {
            this.radioStationUrl = radioStationUrl;
            return this;
        }

        /**
         * @return The collectionType
         */
        public String getCollectionType() {
            return collectionType;
        }

        /**
         * @param collectionType The collectionType
         */
        public void setCollectionType(String collectionType) {
            this.collectionType = collectionType;
        }

        public Result withCollectionType(String collectionType) {
            this.collectionType = collectionType;
            return this;
        }

        /**
         * @return The collectionId
         */
        public int getCollectionId() {
            return collectionId;
        }

        /**
         * @param collectionId The collectionId
         */
        public void setCollectionId(int collectionId) {
            this.collectionId = collectionId;
        }

        public Result withCollectionId(int collectionId) {
            this.collectionId = collectionId;
            return this;
        }

        /**
         * @return The collectionName
         */
        public String getCollectionName() {
            return collectionName;
        }

        /**
         * @param collectionName The collectionName
         */
        public void setCollectionName(String collectionName) {
            this.collectionName = collectionName;
        }

        public Result withCollectionName(String collectionName) {
            this.collectionName = collectionName;
            return this;
        }

        /**
         * @return The collectionCensoredName
         */
        public String getCollectionCensoredName() {
            return collectionCensoredName;
        }

        /**
         * @param collectionCensoredName The collectionCensoredName
         */
        public void setCollectionCensoredName(String collectionCensoredName) {
            this.collectionCensoredName = collectionCensoredName;
        }

        public Result withCollectionCensoredName(String collectionCensoredName) {
            this.collectionCensoredName = collectionCensoredName;
            return this;
        }

        /**
         * @return The artistViewUrl
         */
        public String getArtistViewUrl() {
            return artistViewUrl;
        }

        /**
         * @param artistViewUrl The artistViewUrl
         */
        public void setArtistViewUrl(String artistViewUrl) {
            this.artistViewUrl = artistViewUrl;
        }

        public Result withArtistViewUrl(String artistViewUrl) {
            this.artistViewUrl = artistViewUrl;
            return this;
        }

        /**
         * @return The collectionViewUrl
         */
        public String getCollectionViewUrl() {
            return collectionViewUrl;
        }

        /**
         * @param collectionViewUrl The collectionViewUrl
         */
        public void setCollectionViewUrl(String collectionViewUrl) {
            this.collectionViewUrl = collectionViewUrl;
        }

        public Result withCollectionViewUrl(String collectionViewUrl) {
            this.collectionViewUrl = collectionViewUrl;
            return this;
        }

        /**
         * @return The artworkUrl60
         */
        public String getArtworkUrl60() {
            return artworkUrl60;
        }

        /**
         * @param artworkUrl60 The artworkUrl60
         */
        public void setArtworkUrl60(String artworkUrl60) {
            this.artworkUrl60 = artworkUrl60;
        }

        public Result withArtworkUrl60(String artworkUrl60) {
            this.artworkUrl60 = artworkUrl60;
            return this;
        }

        /**
         * @return The artworkUrl100
         */
        public String getArtworkUrl100() {
            return artworkUrl100;
        }

        /**
         * @param artworkUrl100 The artworkUrl100
         */
        public void setArtworkUrl100(String artworkUrl100) {
            this.artworkUrl100 = artworkUrl100;
        }

        public Result withArtworkUrl100(String artworkUrl100) {
            this.artworkUrl100 = artworkUrl100;
            return this;
        }

        /**
         * @return The collectionPrice
         */
        public double getCollectionPrice() {
            return collectionPrice;
        }

        /**
         * @param collectionPrice The collectionPrice
         */
        public void setCollectionPrice(double collectionPrice) {
            this.collectionPrice = collectionPrice;
        }

        public Result withCollectionPrice(double collectionPrice) {
            this.collectionPrice = collectionPrice;
            return this;
        }

        /**
         * @return The collectionExplicitness
         */
        public String getCollectionExplicitness() {
            return collectionExplicitness;
        }

        /**
         * @param collectionExplicitness The collectionExplicitness
         */
        public void setCollectionExplicitness(String collectionExplicitness) {
            this.collectionExplicitness = collectionExplicitness;
        }

        public Result withCollectionExplicitness(String collectionExplicitness) {
            this.collectionExplicitness = collectionExplicitness;
            return this;
        }

        /**
         * @return The trackCount
         */
        public int getTrackCount() {
            return trackCount;
        }

        /**
         * @param trackCount The trackCount
         */
        public void setTrackCount(int trackCount) {
            this.trackCount = trackCount;
        }

        public Result withTrackCount(int trackCount) {
            this.trackCount = trackCount;
            return this;
        }

        /**
         * @return The copyright
         */
        public String getCopyright() {
            return copyright;
        }

        /**
         * @param copyright The copyright
         */
        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

        public Result withCopyright(String copyright) {
            this.copyright = copyright;
            return this;
        }

        /**
         * @return The country
         */
        public String getCountry() {
            return country;
        }

        /**
         * @param country The country
         */
        public void setCountry(String country) {
            this.country = country;
        }

        public Result withCountry(String country) {
            this.country = country;
            return this;
        }

        /**
         * @return The currency
         */
        public String getCurrency() {
            return currency;
        }

        /**
         * @param currency The currency
         */
        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public Result withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        /**
         * @return The releaseDate
         */
        public String getReleaseDate() {
            return releaseDate;
        }

        /**
         * @param releaseDate The releaseDate
         */
        public void setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
        }

        public Result withReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        /**
         * @return The contentAdvisoryRating
         */
        public String getContentAdvisoryRating() {
            return contentAdvisoryRating;
        }

        /**
         * @param contentAdvisoryRating The contentAdvisoryRating
         */
        public void setContentAdvisoryRating(String contentAdvisoryRating) {
            this.contentAdvisoryRating = contentAdvisoryRating;
        }

        public Result withContentAdvisoryRating(String contentAdvisoryRating) {
            this.contentAdvisoryRating = contentAdvisoryRating;
            return this;
        }

    }
}