package com.google.cloud.vision.samples.automl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.automl.v1beta1.AnnotationPayload;
import com.google.cloud.automl.v1beta1.AutoMlClient;
import com.google.cloud.automl.v1beta1.ClassificationProto.ClassificationEvaluationMetrics;
import com.google.cloud.automl.v1beta1.ClassificationProto.ClassificationEvaluationMetrics.ConfidenceMetricsEntry;
import com.google.cloud.automl.v1beta1.ClassificationProto.ClassificationType;
import com.google.cloud.automl.v1beta1.Dataset;
import com.google.cloud.automl.v1beta1.DatasetName;
import com.google.cloud.automl.v1beta1.ExamplePayload;
import com.google.cloud.automl.v1beta1.GcsSource;
import com.google.cloud.automl.v1beta1.Image;
import com.google.cloud.automl.v1beta1.ImageClassificationDatasetMetadata;
import com.google.cloud.automl.v1beta1.ImageClassificationModelMetadata;
import com.google.cloud.automl.v1beta1.InputConfig;
import com.google.cloud.automl.v1beta1.ListModelEvaluationsRequest;
import com.google.cloud.automl.v1beta1.LocationName;
import com.google.cloud.automl.v1beta1.Model;
import com.google.cloud.automl.v1beta1.ModelEvaluation;
import com.google.cloud.automl.v1beta1.ModelEvaluationName;
import com.google.cloud.automl.v1beta1.ModelName;
import com.google.cloud.automl.v1beta1.OperationMetadata;
import com.google.cloud.automl.v1beta1.PredictResponse;
import com.google.cloud.automl.v1beta1.PredictionServiceClient;
import com.google.protobuf.ByteString;
import com.google.protobuf.Empty;

public class main {
		public static void main(String[] args) throws Exception {

			AutoMlAPI.createDataset("oos-atree-224402", "us-central1", "clothes",false);

//			AutoMlAPI.importData("oos-atree-224402", "us-central1", "flowers", "https://console.cloud.google.com/storage/browser");
			AutoMlAPI.predict("oos-atree-224402", "us-central1", "ICN4697691674548420650", "C:\\Users\\admin\\Desktop\\img\\sun3.jpg", "0.7");
			
		}
	
}

