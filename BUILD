load("@aspect_bazel_lib//lib:tar.bzl", "tar")
load("@rules_java//java:defs.bzl", "java_binary", "java_library", "java_test")

package(default_visibility = ["//visibility:public"])

java_library(
    name = "java-maven-lib",
    srcs = glob(["src/main/java/com/ap/jdbcunit/**/*.java"]),
    deps = ["@maven//:com_google_guava_guava"],
)

java_test(
    name = "tests",
    srcs = glob(["src/test/java/com/ap/jdbcunit/**/*.java"]),
    test_class = "com.ap.jdbcunit.AllTests",
    deps = [
        ":java-maven-lib",
        "@maven//:com_google_guava_guava",
        "@maven//:junit_junit",
    ],
)

