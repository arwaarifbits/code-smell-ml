import pandas as pd

# Load datasets
class_df = pd.read_csv("data/processed/class_features.csv")
method_df = pd.read_csv("data/processed/method_features.csv")

# Label rules

# Large Class
class_df["is_large_class"] = class_df["num_methods"].apply(lambda x: 1 if x > 15 else 0)

# God Class (simplified)
class_df["is_god_class"] = class_df["loc"].apply(lambda x: 1 if x > 300 else 0)

# Long Method
method_df["is_long_method"] = method_df["loc"].apply(lambda x: 1 if x > 30 else 0)

# Long Parameter List
method_df["is_long_param"] = method_df["num_params"].apply(lambda x: 1 if x > 4 else 0)

# Save labeled data
class_df.to_csv("data/processed/class_labeled.csv", index=False)
method_df.to_csv("data/processed/method_labeled.csv", index=False)

print("Labeling done!")