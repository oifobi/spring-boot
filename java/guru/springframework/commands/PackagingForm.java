package guru.springframework.commands;

public class PackagingForm {
    private Long packagingTypeId;

    private String packagingTypes;

    public Long getPackagingTypeId() {
        return packagingTypeId;
    }

    public void setPackagingTypeId(Long packagingTypeId) {
        this.packagingTypeId = packagingTypeId;
    }


    public String getPackagingTypes() {
        return packagingTypes;
    }

    public void setPackagingTypes(String packagingTypes) {
        this.packagingTypes = packagingTypes;
    }
}
