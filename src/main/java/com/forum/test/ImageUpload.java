package com.forum.test;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;

import com.google.gson.Gson;

/**
 * Servlet implementation class UploadImage
 */
@WebServlet(name = "ImageUploadServlet", urlPatterns = {
    "/upload_image"
})

@MultipartConfig
public class ImageUpload extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageUpload() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // The route on which the file is saved.
        File uploads = new File("/forum/src/main/resources/file/");
        String multipartContentType = "multipart/form-data";
        String fieldname = "file";
        Part filePart = request.getPart(fieldname);
        Map < Object, Object > responseData = null;

        // Create path components to save the file.
        final PrintWriter writer = response.getWriter();

        String linkName = null;
        String name = null;

        try {
            // Check content type.
            if (request.getContentType() == null ||
                request.getContentType().toLowerCase().indexOf(multipartContentType) == -1) {

                throw new Exception("Invalid contentType. It must be " + multipartContentType);
            }

            // Get file Part based on field name and also image extension.
            filePart = request.getPart(fieldname);
            String type = filePart.getContentType();
            type = type.substring(type.lastIndexOf("/") + 1);

            // Generate random name.
            String extension = type;
            extension = (extension != null && extension != "") ? "." + extension : extension;
            name = UUID.randomUUID().toString() + extension ;

            // Get absolute server path.
            String absoluteServerPath = uploads + name;

            // Create link.
            String path = request.getHeader("referer");
            linkName = path + "files/" + name;

            // Validate image.
            String mimeType = filePart.getContentType();
            String[] allowedExts = new String[] {
                "gif",
                "jpeg",
                "jpg",
                "png",
                "svg",
                "blob"
            };
            String[] allowedMimeTypes = new String[] {
                "image/gif",
                "image/jpeg",
                "image/pjpeg",
                "image/x-png",
                "image/png",
                "image/svg+xml"
            };

            if (!ArrayUtils.contains(allowedExts, FilenameUtils.getExtension(absoluteServerPath)) ||
                !ArrayUtils.contains(allowedMimeTypes, mimeType.toLowerCase())) {

                // Delete the uploaded image if it dose not meet the validation.
                File file = new File(uploads + name);
                if (file.exists()) {
                    file.delete();
                }

                throw new Exception("Image does not meet the validation.");
            }

            // Save the file on server.

            File file = new File(uploads, name);

            try (InputStream input = filePart.getInputStream()) {
                Files.copy(input, file.toPath());
            } catch (Exception e) {
            	writer.println("<br/> ERROR: " + e);
            }

        } catch (Exception e) {
            e.printStackTrace();
            writer.println("You either did not specify a file to upload or are " +
                "trying to upload a file to a protected or nonexistent " +
                "location.");
            writer.println("<br/> ERROR: " + e.getMessage());
            responseData = new HashMap < Object, Object > ();
            responseData.put("error", e.toString());

        } finally {
            // Build response data.
            responseData = new HashMap < Object, Object > ();
            responseData.put("link", linkName);

            // Send response data.
            String jsonResponseData = new Gson().toJson(responseData);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(jsonResponseData);
        }
    }
}