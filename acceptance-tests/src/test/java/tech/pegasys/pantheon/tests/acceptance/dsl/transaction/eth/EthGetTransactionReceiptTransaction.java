/*
 * Copyright 2018 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package tech.pegasys.pantheon.tests.acceptance.dsl.transaction.eth;

import static org.assertj.core.api.Assertions.assertThat;

import tech.pegasys.pantheon.tests.acceptance.dsl.transaction.Transaction;

import java.io.IOException;
import java.util.Optional;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

public class EthGetTransactionReceiptTransaction
    implements Transaction<Optional<TransactionReceipt>> {

  private final String input;

  EthGetTransactionReceiptTransaction(final String input) {
    this.input = input;
  }

  @Override
  public Optional<TransactionReceipt> execute(final Web3j node) {
    try {
      final EthGetTransactionReceipt result = node.ethGetTransactionReceipt(input).send();
      assertThat(result.hasError()).isFalse();
      return result.getTransactionReceipt();
    } catch (final IOException e) {
      throw new RuntimeException(e);
    }
  }
}
