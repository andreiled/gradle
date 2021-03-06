/*
 * A set of generic services and utilities.
 *
 * Should have a very small set of dependencies, and should be appropriate to embed in an external
 * application (eg as part of the tooling API).
 */

plugins {
    id("gradlebuild.distribution.api-java")
    id("gradlebuild.jmh")
}

gradlebuildJava.usedInWorkers()

dependencies {
    api(project(":baseAnnotations"))
    api(project(":hashing"))

    implementation(libs.slf4jApi)
    implementation(libs.guava)
    implementation(libs.commonsLang)
    implementation(libs.commonsIo)
    implementation(libs.asm)

    integTestImplementation(project(":logging"))

    testFixturesImplementation(libs.guava)
    testImplementation(testFixtures(project(":core")))

    integTestDistributionRuntimeOnly(project(":distributionsCore"))

    jmh(libs.bouncycastleProvider)
    jmh(libs.guava)
}

jmh.include = listOf("HashingAlgorithmsBenchmark")

moduleIdentity.createBuildReceipt()
