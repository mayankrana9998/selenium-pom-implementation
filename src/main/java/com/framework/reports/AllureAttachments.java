package com.framework.reports;

import io.qameta.allure.Attachment;

public final class AllureAttachments {

    private AllureAttachments() {
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public static byte[] attachScreenshot(byte[] screenshot) {
        return screenshot;
    }
}
